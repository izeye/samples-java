package samples.java.org.apache.commons.io;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by izeye on 14. 11. 28..
 */
public class IOUtilsTest {

  @Test
  public void testToString() throws IOException {
    String filename = "src/main/java/samples/java/org/apache/commons/io/test.txt";
    String string = IOUtils.toString(new FileReader(filename));
    System.out.println(string);
  }

}