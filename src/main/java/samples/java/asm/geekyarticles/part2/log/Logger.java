package samples.java.asm.geekyarticles.part2.log;

/**
 * Created by izeye on 14. 12. 11..
 */
public class Logger {

  public static void logMethodStart(String methodName) {
    System.out.println("Starting method: " + methodName);
  }

  public static void logMethodReturn(String methodName) {
    System.out.println("Ending method: " + methodName);
  }

}
