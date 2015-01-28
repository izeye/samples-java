package samples.java.java.lang;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by izeye on 2014. 11. 24..
 */
public class StringTest {

  @Test
  public void split() {
    String string = "a b  c   d";
    String[] split = string.split(" ");
    System.out.println(Arrays.asList(split));
  }

  @Test
  public void replace() {
    String string = "a,b,c";
    assertThat(string.replace(',', ' '), is("a b c"));
  }

}
