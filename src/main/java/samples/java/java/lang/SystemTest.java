package samples.java.java.lang;

import org.junit.Test;

/**
 * Created by izeye on 2014. 11. 24..
 */
public class SystemTest {

    @Test
    public void getProperty() {
        System.out.println(System.getProperty("java.io.tmpdir"));
    }

}
