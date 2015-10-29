package company.tothepoint.demo.service.person.controller;

import company.tothepoint.demo.service.person.model.Person;
import company.tothepoint.demo.service.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by stevenheyninck on 29/10/15.
 */
@RestController
@RequestMapping("/people")
public class PersonController {
    @Autowired private PersonRepository personRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Person> listPeople() {
        return personRepository.findAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Person getPerson(@PathVariable("id") Long id) {
        return personRepository.findOne(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createPerson(@RequestBody Person person) {
        personRepository.save(new Person(person.getFirstName(), person.getLastName()));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePerson(@PathVariable("id") Long id, @RequestBody Person person) {
        Person existingPerson = personRepository.findOne(id);
        existingPerson.setFirstName(person.getFirstName());
        existingPerson.setLastName(person.getLastName());
        personRepository.save(existingPerson);
    }
}
