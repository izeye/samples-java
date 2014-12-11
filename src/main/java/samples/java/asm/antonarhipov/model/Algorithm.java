package samples.java.asm.antonarhipov.model;

import samples.java.asm.antonarhipov.Trace;

/**
 * Created by izeye on 14. 12. 11..
 */
public class Algorithm {

  /**
   * A method for test without Trace annotation.
   */
  public void run1() {
    int value = 0;
    value += 1;
    value += 1;
    value += 1;
    value += 1;
    value++;
    value++;
    value++;
    value++;
    System.out.println("value = " + value);
  }

  /**
   * A method for test with Trace annotation.
   */
  @Trace
  public void run2() {
    int value = 0;
    value += 1;
    value += 1;
    value += 1;
    value += 1;
    value++;
    value++;
    value++;
    value++;
    System.out.println("value = " + value);
  }

}
