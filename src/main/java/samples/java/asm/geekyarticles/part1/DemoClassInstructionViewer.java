package samples.java.asm.geekyarticles.part1;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by izeye on 14. 12. 11..
 */
public class DemoClassInstructionViewer {

  public static class MethodPrinterVisitor extends ClassVisitor {
    public MethodPrinterVisitor(int api) {
      super(api);
    }

    public MethodPrinterVisitor(int api, ClassVisitor cv) {
      super(api, cv);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
      System.out.println(name + " " + desc);

      MethodVisitor methodVisitor = new MethodVisitor(Opcodes.ASM5) {
        @Override
        public void visitInsn(int opcode) {
          System.out.println(opcode);
          super.visitInsn(opcode);
        }
      };
      return methodVisitor;
    }
  }

  public static void main(String[] args) throws IOException {
    InputStream is = AsmHelloWorld.class.getResourceAsStream("/samples/java/asm/geekyarticles/part1/AsmHelloWorld.class");
    ClassReader classReader = new ClassReader(is);
    classReader.accept(new MethodPrinterVisitor(Opcodes.ASM5), 0);
  }

}
