package samples.java.java.lang;

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

}
