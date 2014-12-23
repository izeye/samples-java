package samples.java.lombok.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by izeye on 14. 12. 23..
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

  private String name;
  private int age;

}
