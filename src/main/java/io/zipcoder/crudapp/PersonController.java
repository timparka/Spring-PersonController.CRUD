package io.zipcoder.crudapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/people")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping
    Person createPerson(@RequestBody Person p) {
        return personService.save(p);
    }

    @GetMapping("/{id}")
    Person getPerson(@PathVariable int id) {
        return personService.findOne(id);
    }

    @GetMapping
    List<Person> getPersonList() {
        return personService.findAll();
    }

    @PutMapping("/{id}")
    Person updatePerson(@PathVariable int id, @RequestBody Person p) {
        p.setId(id);
        return personService.save(p);
    }

    @DeleteMapping("/{id}")
    void DeletePerson(@PathVariable int id) {
        personService.delete(id);
    }
}
