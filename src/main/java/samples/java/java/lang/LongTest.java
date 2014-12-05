package samples.java.java.lang;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

/**
 * Created by izeye on 2014. 11. 21..
 */
public class LongTest {

  @Test
  public void valueOf() {
    assertThat(Long.valueOf("1"), is(sameInstance(Long.valueOf("1"))));
    assertThat(Long.valueOf("127"), is(sameInstance(Long.valueOf("127"))));
    assertThat(Long.valueOf("128"), is(not(sameInstance(Long.valueOf("128")))));
  }

}
