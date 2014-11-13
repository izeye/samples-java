package samples.java.java.time;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by izeye on 2014. 11. 13..
 */
public class LocalDateTimeTest {

    @Test
    public void date2LocalDateTime() {
        Date date = new Date();
        System.out.println(date);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        System.out.println(localDateTime);
    }

    @Test
    public void localDateTime2Date() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(date);
    }

}
