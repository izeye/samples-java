package samples.java.asm.geekyarticles;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by izeye on 14. 12. 11..
 */
public class AsmHelloWorld {

  public static void main(String[] args) throws IOException {
    ClassVisitor classVisitor = new ClassVisitor(Opcodes.ASM5) {
      @Override
      public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        System.out.println("Visiting class: " + name);
        System.out.println("Class major version: " + version);
        System.out.println("Super class: " + superName);
        super.visit(version, access, name, signature, superName, interfaces);
      }

      @Override
      public void visitOuterClass(String owner, String name, String desc) {
        System.out.println("Outer class: " + owner);
        super.visitOuterClass(owner, name, desc);
      }

      @Override
      public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        System.out.println("Annotation: " + desc);
        return super.visitAnnotation(desc, visible);
      }

      @Override
      public void visitAttribute(Attribute attr) {
        System.out.println("Class attribute: " + attr.type);
        super.visitAttribute(attr);
      }

      @Override
      public void visitInnerClass(String name, String outerName, String innerName, int access) {
        System.out.println("Inner class: " + innerName + " defined in " + outerName);
        super.visitInnerClass(name, outerName, innerName, access);
      }

      @Override
      public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        System.out.println("Field: " + name + " " + desc + ", value: " + value);
        return super.visitField(access, name, desc, signature, value);
      }

      @Override
      public void visitEnd() {
        System.out.println("Method ends here");
        super.visitEnd();
      }

      @Override
      public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        System.out.println("Method: " + name + " " + desc);
        return super.visitMethod(access, name, desc, signature, exceptions);
      }

      @Override
      public void visitSource(String source, String debug) {
        System.out.println("Source: " + source);
        super.visitSource(source, debug);
      }
    };
    InputStream is = AsmHelloWorld.class.getResourceAsStream("/java/lang/String.class");
    ClassReader classReader = new ClassReader(is);
    classReader.accept(classVisitor, 0);
  }

}
