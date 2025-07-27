package com.accounts.controller.v0;

import com.accounts.model.Person;
import com.accounts.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    PersonService service;

    @GetMapping("/")
    public List<Person> getAll(){
        return service.getAllPerson();
    }

    @PostMapping("/save")
    public void addPerson(@RequestBody Person person){
        service.savePerson(person);
    }

    @GetMapping("/ById")
    public Person getById(@RequestParam  Long id){
        return service.getPersonById(id);
    }

    @DeleteMapping("/delete")
    public void deleteUserById(@RequestParam Long id){
        service.deletePersonById(id);
    }

    @GetMapping("/api/persons")
    public Page<Person> getProducts(Pageable pageable) {
        return service.findAllPerson(pageable);
    }
}
