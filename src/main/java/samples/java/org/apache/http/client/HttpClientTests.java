package samples.java.org.apache.http.client;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by izeye on 14. 12. 26..
 */
public class HttpClientTests {

  @Test
  public void test() throws IOException {
    HttpClient httpClient = HttpClients.createDefault();
//    String uri = "http://bupyeong.himedia.co.kr/?NaPm=ct%3Di45e8lqo%7Cci%3D0x41003EaDPiQVG900jd%7Ctr%3Dsa%7Chk%3D17483ac5316537ed0e986093815956287f9d4013&NVKWD=%ED%95%98%EC%9D%B4%EB%AF%B8%EB%94%94%EC%96%B4%EC%BB%B4%ED%93%A8%ED%84%B0%ED%95%99%EC%9B%90&NVADKWD=%ED%95%98%EC%9D%B4%EB%AF%B8%EB%94%94%EC%96%B4%EC%BB%B4%ED%93%A8%ED%84%B0%ED%95%99%EC%9B%90&NVAR=MPL&NVADID=210495668+0x41003EaDPiQVG900jd";
    String uri = "http://localhost:18080/?NaPm=ct%3Di45e8lqo%7Cci%3D0x41003EaDPiQVG900jd%7Ctr%3Dsa%7Chk%3D17483ac5316537ed0e986093815956287f9d4013&NVKWD=%ED%95%98%EC%9D%B4%EB%AF%B8%EB%94%94%EC%96%B4%EC%BB%B4%ED%93%A8%ED%84%B0%ED%95%99%EC%9B%90&NVADKWD=%ED%95%98%EC%9D%B4%EB%AF%B8%EB%94%94%EC%96%B4%EC%BB%B4%ED%93%A8%ED%84%B0%ED%95%99%EC%9B%90&NVAR=MPL&NVADID=210495668+0x41003EaDPiQVG900jd";
    HttpGet httpGet = new HttpGet(uri);
    httpGet.setHeader("Referer", "http://m.search.naver.com/search.naver?sm=mtb_sug.top&where=m&query=%ED%95%98%EC%9D%B4%EB%AF%B8%EB%94%94%EC%96%B4%EC%BB%B4%ED%93%A8%ED%84%B0%ED%95%99%EC%9B%90&qdt=0&acq=%ED%95%98%EC%9D%B4%EB%AF%B8%EB%94%94%EC%96%B4&acr=2&url=http%3A//adcr.naver.com/adcr%3Fx%3DzhPMFM1uMvVpwk0ZAd0uL////w%3D%3DbL34a1GJTpeKQlBboL%2B9JthgPro%2BKpCL/hfdedZ1yfm%2Bsa4tpI3IFlxtEz08SevYZx0G2BFww8VJA15rGqt18byheRYo14TWO9gR0uc6ZP6e5fpQVmJYEoSQ/lAd9tIJHxrTcJv9b6wNm9ml9W2Q%2BRbSTnsIyaXlcsgJa0SXmVo8OmAdEflOdmB%2Bjpniy8JmeLZzQpFMEXLqFpV%2BlHNKKdzfRefRTx6M4JCrd7g4Jk26o2A2nERv5sbrym2RFCI811V8T05htxouTaOkOiJCqy4Qlm/wDrmmf/nt0qG2h6aAqvU/NCAeLASBZy1j6AMvloSnazzVS04YyCnXl7ig4ziOHuyywzBkqup41cICZ7r75fnVSZL02f9glGGWN1mj1CGF6igyP0oF9864m2Rumx/4aJz7n1/KtZeXDF83QSEJTWnG36LSxhfuMi266zJlZQ64Xd27ayU3GTtZkvZqRZJyWplonw2TZnIZpSV25cqBVa4O4VV0X34mKjYx5x4OrWysfiVkfmqEHOs1jLfxqEULOhNI2tvA/MHmAL1OjKGdsDrEKPIIa6KwjeGTfcLQ7/kaluxNlhQ9O2RPTqCWEu6mmuuFpjSDxjpCtcYiQUQB5AhNfXLdZL12/xDHJVpQB%2B2f8VIPgy2UpxIC/Acthzldic1e40ZK8MstZgJXQ3AXtLaUJoKgjhCfM%2Bz%2BO4Pl/pfbxBHuVL94g9E9tS3zC6bQOk0MZb1TwV4K01nqm6GoGUJ%2Bu2ZMzr2zORDRC1lLCZm5x0SRJ5iqNesrJCnso6v8yrJ8YB6scqIhU7OWeqRis1l7o5hIjwSViBZZ0PUfHMMH6EXt1eSDpdAgDLK6x08iVxLdLj34q/t8KNAO1d30q8cJPg7bfcra455yrbHisr8SoZmQO3rjcF0mytVPgGA%3D%3D%26p%3D0");
    HttpResponse httpResponse = httpClient.execute(httpGet);
    String content = IOUtils.toString(httpResponse.getEntity().getContent());
    System.out.println(content);
  }

  @Test
  public void runServer() throws IOException {
    ServerSocket serverSocket = new ServerSocket(18080);
    Socket socket = serverSocket.accept();
    InputStream is = socket.getInputStream();
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    byte[] buffer = new byte[1024];
    int readBytes;
    while ((readBytes = is.read(buffer)) > 0) {
      baos.write(buffer, 0, readBytes);
    }
    String response = new String(baos.toByteArray(), "UTF-8");
    System.out.println(response);
  }

}
