package samples.java.http.client;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by izeye on 15. 1. 28..
 */
public class HttpClientTests {

  @Test
  public void test() {
    String request = "GET /api/customers?page=0&size=100 HTTP/1.1\r\n" +
        "Accept: text/plain, application/json, application/*+json, */*\r\n" +
        "User-Agent: Java/1.8.0_05\r\n" +
        "Host: localhost:18080\r\n" +
//        "Connection: keep-alive\r\n\r\n";
        "Connection: Close\r\n\r\n";
    try (
        Socket socket = new Socket("localhost", 18080);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream()
    ) {
      Thread thread = new Thread() {
        @Override
        public void run() {
          try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];

            int readBytes;
            while ((readBytes = is.read(buffer)) > 0) {
              baos.write(buffer, 0, readBytes);
            }
            String response = new String(baos.toByteArray(), "UTF-8");
            System.out.println(response);
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      };
      thread.start();
      os.write(request.getBytes("UTF-8"));
      os.flush();
      thread.join();
    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
