package com.accounts.service;

import com.accounts.model.Person;
import com.accounts.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

  @Autowired
  private PersonRepo service;


    @Override
    public List<Person> getAllPerson() {
        return service.findAll();
    }

    @Override
    public void savePerson(Person person) {
        this.service.save(person);
    }

    @Override
    public Person getPersonById(long id) {
        Optional<Person> optionalPerson = service.findById(id);
        Person person = null;
        if (optionalPerson.isPresent()) {
            person = optionalPerson.get();
        } else {
            return new Person();
        }
        return person;
    }

    @Override
    public void deletePersonById(long id) {
        this.service.deleteById(id);
    }

    @Override
    public Page<Person> findAllPerson(Pageable pageable) {
        return service.findAll(pageable);
    }

}
