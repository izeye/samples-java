package samples.java.java.net;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by izeye on 14. 12. 19..
 */
public class InetAddressTests {

  @Test
  public void getCanonicalHostName() throws UnknownHostException {
    InetAddress localHost = InetAddress.getLocalHost();
    System.out.println(localHost.getCanonicalHostName());
    System.out.println(localHost.getHostName());
  }

}
