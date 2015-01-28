package samples.java.java.net;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by izeye on 15. 1. 28..
 */
public class ServerSocketTests {

  @Test
  public void test() {
    try (
        ServerSocket serverSocket = new ServerSocket(18080);
        Socket socket = serverSocket.accept();
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream()
    ) {
      byte[] buffer = new byte[1024];

      int readBytes;
      while ((readBytes = is.read(buffer)) > 0) {
        baos.write(buffer, 0, readBytes);
      }
      String request = new String(baos.toByteArray(), "UTF-8");
      System.out.println(request);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
