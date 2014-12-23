package samples.java.lombok.service;

import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import samples.java.lombok.domain.Person;

/**
 * Created by izeye on 14. 12. 23..
 */
@Slf4j
public class DefaultPersonService implements PersonService {

//  Logger log = LoggerFactory.getLogger(getClass());

  @Override
  public void log(Person person) {
    log.debug("person: {}", person);
  }

}
