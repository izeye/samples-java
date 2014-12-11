package samples.java.asm.classloader.model;

import samples.java.asm.classloader.Trace;

/**
 * Created by izeye on 14. 12. 11..
 */
public class Algorithm {

  public void run1() {
    int i = 0;
    i += 1;
    i += 1;
    i += 1;
    i += 1;
    i++;
    i++;
    i++;
    i++;
    System.out.println("i = " + i);
  }

  @Trace
  public void run2() {
    int i = 0;
    i += 1;
    i += 1;
    i += 1;
    i += 1;
    i++;
    i++;
    i++;
    i++;
    System.out.println("i = " + i);
  }

}
