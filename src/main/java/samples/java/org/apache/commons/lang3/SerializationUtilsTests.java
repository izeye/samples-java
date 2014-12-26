package samples.java.org.apache.commons.lang3;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsSame.sameInstance;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import java.io.Serializable;

/**
 * Created by izeye on 14. 12. 26..
 */
public class SerializationUtilsTests {

  @Test
  public void testClone() {
    B b = new B("b1", "b2");
    A a = new A("a1", "a2", b);

    A clonedA = SerializationUtils.clone(a);

    assertThat(clonedA, is(not(sameInstance(a))));
    assertThat(clonedA.getA1(), is(a.getA1()));
    assertThat(clonedA.getA2(), is(a.getA2()));

    assertThat(clonedA.getB(), is(not(sameInstance(b))));
    assertThat(clonedA.getB().getB1(), is(b.getB1()));
    assertThat(clonedA.getB().getB2(), is(b.getB2()));
  }

  static class A implements Serializable {
    private String a1;
    private String a2;

    private B b;

    public A(String a1, String a2, B b) {
      this.a1 = a1;
      this.a2 = a2;
      this.b = b;
    }

    public String getA1() {
      return a1;
    }

    public void setA1(String a1) {
      this.a1 = a1;
    }

    public String getA2() {
      return a2;
    }

    public void setA2(String a2) {
      this.a2 = a2;
    }

    public B getB() {
      return b;
    }

    public void setB(B b) {
      this.b = b;
    }
  }

  static class B implements Serializable {
    private String b1;
    private String b2;

    public B(String b1, String b2) {
      this.b1 = b1;
      this.b2 = b2;
    }

    public String getB1() {
      return b1;
    }

    public void setB1(String b1) {
      this.b1 = b1;
    }

    public String getB2() {
      return b2;
    }

    public void setB2(String b2) {
      this.b2 = b2;
    }
  }

}
