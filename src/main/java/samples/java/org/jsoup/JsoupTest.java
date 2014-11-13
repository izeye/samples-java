package samples.java.org.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.util.Iterator;

/**
 * Created by izeye on 2014. 11. 13..
 */
public class JsoupTest {

    @Test
    public void test() throws IOException {
        Document document = Jsoup.connect("http://en.wikipedia.org/").get();
        Elements elements = document.select("#mp-itn b a");
        Iterator<Element> iterator = elements.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        String title = document.title();
        System.out.println(title);
    }

}
