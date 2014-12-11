package samples.java.asm.antonarhipov;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by izeye on 14. 12. 11..
 */
public class Main {

  /**
   * An ASM sample with a custom class loader.
   *
   * @param args command line arguments
   * @throws ClassNotFoundException    exception
   * @throws NoSuchMethodException     exception
   * @throws IllegalAccessException    exception
   * @throws InstantiationException    exception
   * @throws InvocationTargetException exception
   */
  public static void main(String[] args) throws
      ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
      InstantiationException, InvocationTargetException {
    MyClassLoader classLoader = new MyClassLoader();

    Class clazz = classLoader.findClass("samples.java.asm.antonarhipov.model.Algorithm");
    Object algorithm = clazz.newInstance();

    Method method = clazz.getDeclaredMethod("run1");
    method.invoke(algorithm);

    method = clazz.getDeclaredMethod("run2");
    method.invoke(algorithm);
  }

}
