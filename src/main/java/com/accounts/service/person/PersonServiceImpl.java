package com.accounts.service.person;

import com.accounts.model.Person;
import com.accounts.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Person savePerson(Person person) {
        return this.service.save(person);
    }

    @Override
    public Optional<Person> getPersonById(long id) {
        return service.findById(id);
    }

    @Override
    public boolean deletePersonById(long id) {
        Optional<Person> person = service.findById(id);
        if (person.isPresent()){
            service.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Page<Person> findAllPerson(Pageable pageable) {
        return service.findAll(pageable);
    }

}
