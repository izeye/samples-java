package samples.java.asm.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by izeye on 14. 12. 11..
 */
public class Main {

  public static void main(String[] args) throws
      ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
      InstantiationException, InvocationTargetException {
    MyClassLoader cl = new MyClassLoader();

    Class c = cl.findClass("samples.java.asm.classloader.model.Algorithm");
    Object algorithm = c.newInstance();

    Method m = c.getDeclaredMethod("run1");
    m.invoke(algorithm);

    m = c.getDeclaredMethod("run2");
    m.invoke(algorithm);
  }

}
