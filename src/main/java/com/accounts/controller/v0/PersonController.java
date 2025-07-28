package com.accounts.controller.v0;

import com.accounts.model.Person;
import com.accounts.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    PersonService service;

    @GetMapping("/")
    public ResponseEntity<List<Person>> getAll(){
        List<Person> person = service.getAllPerson();
        return new ResponseEntity<>(person, HttpStatus.ACCEPTED);
    }

    @PostMapping("/save")
    public ResponseEntity<Person> addPerson(@RequestBody Person person){
        Person savedPerson = service.savePerson(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @GetMapping("/ById")
    public ResponseEntity<Optional<Person>> getById(@RequestParam  Long id){
        Optional<Person> person = service.getPersonById(id);
        if (person.isPresent()){
            return new ResponseEntity<Optional<Person>>(person, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUserById(@RequestParam Long id){
      boolean deleted =  service.deletePersonById(id);
      if(deleted){
          return ResponseEntity.noContent().build();
      } else {
          return  ResponseEntity.notFound().build();
      }
    }

    @GetMapping("/api/persons")
    public ResponseEntity<Page<Person>> getPersons(Pageable pageable) {
        return new ResponseEntity<>(service.findAllPerson(pageable), HttpStatus.OK);
    }
}
