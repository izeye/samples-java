package samples.java.asm.antonarhipov;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * Created by izeye on 14. 12. 11..
 */
public class MyClassVisitor extends ClassVisitor {

  public MyClassVisitor(ClassVisitor cv) {
    super(Opcodes.ASM5, cv);
  }

  @Override
  public MethodVisitor visitMethod(
      int access, String name, String desc, String signature, String[] exceptions) {
    MethodVisitor methodVisitor =  super.visitMethod(access, name, desc, signature, exceptions);
    return new MyMethodVisitor(methodVisitor, access, name, desc);
  }

}
