package io.zipcoder.crudapp.Repository;

import org.springframework.data.repository.CrudRepository;

import io.zipcoder.crudapp.Entity.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {
}
