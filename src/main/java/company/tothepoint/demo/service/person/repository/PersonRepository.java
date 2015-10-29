package company.tothepoint.demo.service.person.repository;

import company.tothepoint.demo.service.person.model.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by stevenheyninck on 29/10/15.
 */
public interface PersonRepository extends CrudRepository<Person, Long> {
}
