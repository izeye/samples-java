package samples.java.asm;

/**
 * Created by nbp on 2014-12-10.
 */

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.FileOutputStream;

public class HelloWorldDump implements Opcodes {

  /**
   * Dump the HelloWorld class.
   * @return dumped bytes
   * @throws Exception exception
   */
  public static byte[] dump() throws Exception {
    ClassWriter cw = new ClassWriter(0);
    FieldVisitor fv;
    MethodVisitor mv;
    AnnotationVisitor av0;

//    cw.visit(52, ACC_PUBLIC + ACC_SUPER,
//        "samples/java/asm/HelloWorld", null, "java/lang/Object", null);
    cw.visit(52, ACC_PUBLIC + ACC_SUPER, "HelloWorld", null, "java/lang/Object", null);

    cw.visitSource("HelloWorld.java", null);

    {
      mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
      mv.visitCode();
      Label l0 = new Label();
      mv.visitLabel(l0);
      mv.visitLineNumber(6, l0);
      mv.visitVarInsn(ALOAD, 0);
      mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
      mv.visitInsn(RETURN);
      Label l1 = new Label();
      mv.visitLabel(l1);
//      mv.visitLocalVariable("this", "Lsamples/java/asm/HelloWorld;", null, l0, l1, 0);
      mv.visitLocalVariable("this", "LHelloWorld;", null, l0, l1, 0);
      mv.visitMaxs(1, 1);
      mv.visitEnd();
    }
    {
      mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
      mv.visitCode();
      Label l0 = new Label();
      mv.visitLabel(l0);
      mv.visitLineNumber(9, l0);
      mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
      mv.visitLdcInsn("Hello, world!");
      mv.visitMethodInsn(INVOKEVIRTUAL,
          "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
      Label l1 = new Label();
      mv.visitLabel(l1);
      mv.visitLineNumber(10, l1);
      mv.visitInsn(RETURN);
      Label l2 = new Label();
      mv.visitLabel(l2);
      mv.visitLocalVariable("args", "[Ljava/lang/String;", null, l0, l2, 0);
      mv.visitMaxs(2, 1);
      mv.visitEnd();
    }
    cw.visitEnd();

    return cw.toByteArray();
  }

  /**
   * Create a HelloWorld class file.
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    FileOutputStream fos = new FileOutputStream(new File("./HelloWorld.class"));
    fos.write(dump());
    fos.close();
  }

}
