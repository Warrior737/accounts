package com.accounts.service;

import com.accounts.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonService {

    List<Person> getAllPerson();
    void savePerson(Person person);
    Person getPersonById(long id);

    void deletePersonById(long id);

    Page<Person> findAllPerson(Pageable pageable);
}
