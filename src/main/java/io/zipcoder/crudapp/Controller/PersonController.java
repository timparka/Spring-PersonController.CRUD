package io.zipcoder.crudapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.zipcoder.crudapp.Entity.Person;
import io.zipcoder.crudapp.Service.PersonService;

@RestController
@RequestMapping("/people")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person p) {
        return new ResponseEntity<>(personService.save(p), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable int id) {
        return new ResponseEntity<>(personService.findOne(id),
                personService.findOne(id) != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Person>> getPersonList() {
        return new ResponseEntity<>(personService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable int id, @RequestBody Person p) {
        Person existPerson = personService.findOne(id);
        p.setId(id);
        Person savePerson = personService.save(p);

        if (existPerson == null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(savePerson);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(savePerson);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> DeletePerson(@PathVariable int id) {
        personService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    
    }
}
