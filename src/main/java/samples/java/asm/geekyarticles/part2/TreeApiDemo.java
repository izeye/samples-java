package samples.java.asm.geekyarticles.part2;

import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;
import static org.objectweb.asm.Opcodes.ASM5;
import static org.objectweb.asm.Opcodes.GETSTATIC;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;
import static org.objectweb.asm.Opcodes.RETURN;
import static org.objectweb.asm.Opcodes.V1_8;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by izeye on 14. 12. 11..
 */
public class TreeApiDemo {

  public static void main(String[] args) throws IOException {
    ClassNode classNode = new ClassNode(ASM5);

    classNode.version = V1_8;
    classNode.access = ACC_PUBLIC;
    classNode.signature = "LGenerated;";
    classNode.name = "Generated";
    classNode.superName = "java/lang/Object";

    MethodNode mainMethod = new MethodNode(
        ASM5, ACC_PUBLIC | ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
    mainMethod.instructions.add(
        new FieldInsnNode(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;"));
    mainMethod.instructions.add(new LdcInsnNode("Hello, world!"));
    mainMethod.instructions.add(new MethodInsnNode(INVOKEVIRTUAL,
            "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false));
    mainMethod.instructions.add(new InsnNode(RETURN));

    classNode.methods.add(mainMethod);

    ClassWriter classWriter = new ClassWriter(
        ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
    classNode.accept(classWriter);

    FileOutputStream fos = new FileOutputStream("./Generated.class");
    fos.write(classWriter.toByteArray());
    fos.close();
  }

}
