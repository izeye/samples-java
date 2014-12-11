package samples.java.asm.antonarhipov;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.commons.AdviceAdapter;

/**
 * Created by izeye on 14. 12. 11..
 */
public class MyMethodVisitor extends AdviceAdapter {

  private String name;

  private boolean trace;

  /**
   * Create a customer method visitor.
   * @param mv the wrapped method visitor
   * @param name the method name
   */
  public MyMethodVisitor(MethodVisitor mv, int access, String name, String desc) {
    super(ASM5, mv, access, name, desc);

    this.name = name;
  }

  @Override
  protected void onMethodEnter() {
    if (trace) {
      trace("enter");
    }
  }

  @Override
  protected void onMethodExit(int opcode) {
    if (trace) {
      trace("return");
    }
  }

  @Override
  public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
    if (desc.equalsIgnoreCase("Lsamples/java/asm/antonarhipov/Trace;") && visible) {
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

  private void trace(String action) {
    mv.visitCode();

    mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
    mv.visitLdcInsn("In " + name + ": " + action);
    mv.visitMethodInsn(INVOKEVIRTUAL,
        "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);

    mv.visitEnd();
  }

  private void trace(int var) {
    mv.visitCode();

    mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
    mv.visitLdcInsn("In " + name + ": ");
    mv.visitMethodInsn(INVOKEVIRTUAL,
        "java/io/PrintStream", "print", "(Ljava/lang/String;)V", false);

    mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
    mv.visitVarInsn(ILOAD, var);
    mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);

    mv.visitEnd();
  }

}
