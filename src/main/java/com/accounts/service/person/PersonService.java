package com.accounts.service.person;

import com.accounts.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    List<Person> getAllPerson();
    Person savePerson(Person person);
    Optional<Person> getPersonById(long id);
    boolean deletePersonById(long id);

    Page<Person> findAllPerson(Pageable pageable);
}
