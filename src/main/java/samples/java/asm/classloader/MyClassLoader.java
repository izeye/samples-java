package samples.java.asm.classloader;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.IOException;

/**
 * Created by izeye on 14. 12. 11..
 */
public class MyClassLoader extends ClassLoader {

  @Override
  protected Class<?> findClass(String name) throws ClassNotFoundException {
    try {
      ClassReader classReader = new ClassReader(name);
      ClassWriter classWriter = new ClassWriter(classReader,
          ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);

      MyClassVisitor classVisitor = new MyClassVisitor(classWriter);

      classReader.accept(classVisitor, ClassReader.EXPAND_FRAMES);

      byte[] bytes = classWriter.toByteArray();
      return defineClass(name, bytes, 0, bytes.length);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return loadClass(name);
  }

}
