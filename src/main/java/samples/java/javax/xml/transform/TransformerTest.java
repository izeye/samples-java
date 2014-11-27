package samples.java.javax.xml.transform;

import org.junit.Test;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by izeye on 14. 11. 28..
 */
public class TransformerTest {

    @Test
    public void transform() throws IOException, TransformerException {
        String xslFilename = "src/main/java/samples/java/javax/xml/transform/test.xsl";
        String xmlSourceFilename = "src/main/java/samples/java/javax/xml/transform/test.xml";

        StringWriter xmlResultResource = new StringWriter();

        Transformer xmlTransformer = TransformerFactory.newInstance().newTransformer(
                new StreamSource(new FileReader(xslFilename)));

        xmlTransformer.transform(
                new StreamSource(new FileReader(xmlSourceFilename)), new StreamResult(xmlResultResource)
        );

        System.out.println(xmlResultResource.getBuffer().toString());
    }

}
