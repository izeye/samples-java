package samples.java.java.net;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by izeye on 15. 1. 7..
 */
public class SocketTests {

  private static final int PORT = 18080;

  @Test
  public void testClose() throws IOException, InterruptedException {
    new Thread() {
      @Override
      public void run() {
        try {
          runServer();
        } catch (IOException e) {
          e.printStackTrace();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }.start();

    Socket socket = new Socket("localhost", PORT);
    Thread.sleep(1000);
    System.out.println("I will close the socket.");
    socket.close();
    System.out.println("I closed the socket.");

    Thread.sleep(10000);
  }

  private void runServer() throws IOException, InterruptedException {
    ServerSocket serverSocket = new ServerSocket(PORT);
    Socket socket = serverSocket.accept();
    InputStream is = socket.getInputStream();
    OutputStream os = socket.getOutputStream();
    while (true) {
      Thread.sleep(100);
      System.out.println(new Date());

      // The following methods DO NOT work.
      System.out.println(socket.isBound());
      System.out.println(socket.isClosed());
      System.out.println(socket.isConnected());
      System.out.println(socket.isInputShutdown());
      System.out.println(socket.isOutputShutdown());

      // The following method DO work.
      System.out.println(is.read());
    }
  }

}
