package samples.java.lombok;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;
import samples.java.lombok.domain.Person;
import samples.java.lombok.service.DefaultPersonService;
import samples.java.lombok.service.PersonService;

/**
 * Created by izeye on 14. 12. 23..
 */
public class LombokTests {

  @Test
  public void testData() {
    String name = "Johnny";
    int age = 20;

    Person person = new Person();
    person.setName(name);
    person.setAge(age);

    assertThat(person.getName(), is(name));
    assertThat(person.getAge(), is(age));
  }

  @Test
  public void testSlf4j() {
    PersonService personService = new DefaultPersonService();
    personService.log(new Person("Johnny", 20));
  }

}
