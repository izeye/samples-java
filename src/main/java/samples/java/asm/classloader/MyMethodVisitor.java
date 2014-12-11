package samples.java.asm.classloader;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.*;

/**
 * Created by izeye on 14. 12. 11..
 */
public class MyMethodVisitor extends MethodVisitor {

  private String name;

  private boolean trace;

  public MyMethodVisitor(MethodVisitor mv, String name) {
    super(ASM5, mv);

    this.name = name;
  }

  @Override
  public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
    if (desc.equalsIgnoreCase("Lsamples/java/asm/classloader/Trace;") && visible) {
      this.trace = true;
    }
    return super.visitAnnotation(desc, visible);
  }

  @Override
  public void visitVarInsn(int opcode, int var) {
    super.visitVarInsn(opcode, var);
    if (opcode == ISTORE) {
      trace(var);
    }
  }

  @Override
  public void visitIincInsn(int var, int increment) {
    super.visitIincInsn(var, increment);
    trace(var);
  }

  private void trace(int var) {
    if (trace) {
      mv.visitCode();

      mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
      mv.visitLdcInsn("In " + name + ": ");
      mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "print", "(Ljava/lang/String;)V", false);

      mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
      mv.visitVarInsn(ILOAD, var);
      mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);

      mv.visitEnd();
    }
  }

}
