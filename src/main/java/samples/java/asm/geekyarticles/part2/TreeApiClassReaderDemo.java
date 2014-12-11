package samples.java.asm.geekyarticles.part2;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by izeye on 14. 12. 11..
 */
public class TreeApiClassReaderDemo {

  /**
   * An ASM sample printing all methods' information.
   * @param args command line arguments
   * @throws IOException exception
   */
  public static void main(String[] args) throws IOException {
    InputStream is = new FileInputStream("./Generated.class");

    ClassReader classReader = new ClassReader(is);
    ClassNode classNode = new ClassNode();

    classReader.accept(classNode, 0);

    List<MethodNode> methods = classNode.methods;
    for (MethodNode methodNode : methods) {
      System.out.println(methodNode.name + " " + methodNode.desc);
    }
  }

}
