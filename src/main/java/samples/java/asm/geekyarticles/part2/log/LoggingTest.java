package samples.java.asm.geekyarticles.part2.log;

/**
 * Created by izeye on 14. 12. 11..
 */
public class LoggingTest {

  public static void run1() {
    System.out.println("run 1");
  }

  @Loggable
  public static void run2() {
    System.out.println("run 2");
  }

  @Loggable
  public static void main(String[] args) {
    run1();
    run2();
  }

}
