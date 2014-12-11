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
      ClassReader cr = new ClassReader(name);
      ClassWriter cw = new ClassWriter(cr,
          ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);

      MyClassVisitor ca = new MyClassVisitor(cw);

      cr.accept(ca, ClassReader.EXPAND_FRAMES);

      byte[] b = cw.toByteArray();
      return defineClass(name, b, 0, b.length);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return loadClass(name);
  }

}
