package samples.java.asm.geekyarticles.part2.log;

import static org.objectweb.asm.Opcodes.ARETURN;
import static org.objectweb.asm.Opcodes.DRETURN;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;
import static org.objectweb.asm.Opcodes.IRETURN;
import static org.objectweb.asm.Opcodes.LRETURN;
import static org.objectweb.asm.Opcodes.RETURN;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by izeye on 14. 12. 11..
 */
public class LoggingInsertion {

  public static void main(String[] args) throws IOException {
    InputStream is = LoggingInsertion.class.getResourceAsStream(
        "/samples/java/asm/geekyarticles/part2/log/LoggingTest.class");

    ClassReader classReader = new ClassReader(is);
    ClassNode classNode = new ClassNode();
    classReader.accept(classNode, 0);

    List<MethodNode> methods = classNode.methods;
    for (MethodNode methodNode : methods) {
      System.out.println(methodNode.name + " " + methodNode.desc);

      List<AnnotationNode> annotations = methodNode.visibleAnnotations;
      if (annotations == null) {
        continue;
      }

      boolean annotationFound = false;
      for (AnnotationNode annotationNode : annotations) {
        if (annotationNode.desc.equals(
            "Lsamples/java/asm/geekyarticles/part2/log/Loggable;")) {
          annotationFound = true;
          break;
        }
      }
      if (annotationFound) {
        InsnList beginList = new InsnList();
        beginList.add(new LdcInsnNode(methodNode.name));
        beginList.add(new MethodInsnNode(INVOKESTATIC,
            "samples/java/asm/geekyarticles/part2/log/Logger",
            "logMethodStart", "(Ljava/lang/String;)V", false));

        ListIterator<AbstractInsnNode> insnNodeIterator = methodNode.instructions.iterator();
        while (insnNodeIterator.hasNext()) {
          System.out.println(insnNodeIterator.next().getOpcode());
        }

        methodNode.instructions.insert(beginList);
        System.out.println(methodNode.instructions);

        insnNodeIterator = methodNode.instructions.iterator();
        while (insnNodeIterator.hasNext()) {
          AbstractInsnNode insnNode = insnNodeIterator.next();
          int opcode = insnNode.getOpcode();
          System.out.println(opcode);

          if (opcode == IRETURN || opcode == RETURN || opcode == ARETURN
              || opcode == ARETURN || opcode == LRETURN || opcode == DRETURN) {
            InsnList endList = new InsnList();
            endList.add(new LdcInsnNode(methodNode.name));
            endList.add(new MethodInsnNode(INVOKESTATIC,
                "samples/java/asm/geekyarticles/part2/log/Logger",
                "logMethodReturn", "(Ljava/lang/String;)V", false));
            methodNode.instructions.insertBefore(insnNode, endList);
          }
        }
      }
    }

    ClassWriter classWriter = new ClassWriter(
        ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
    classNode.accept(classWriter);

    File outDir = new File("./out/samples/java/asm/geekyarticles/part2/log");
    outDir.mkdirs();

    FileOutputStream fos = new FileOutputStream(new File(outDir, "LoggingTest.class"));
    fos.write(classWriter.toByteArray());
    fos.close();
  }

}
