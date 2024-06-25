package com.qa.rest;


import com.qa.entities.Person;
import com.qa.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonControlller {

    private PersonService service;

    public PersonControlller(PersonService service, List<Person> people) {
        this.service = service;

    }



    @GetMapping("/getAll")
    public List<Person> getAll() {

        return this.service.getAll();
    }
    @PostMapping("/create")
    public Person createPerson(@RequestBody Person person){


        return this.service.createPerson(person);

    }

    @DeleteMapping("/remove/{id}")
    public Person removePerson(@PathVariable int id){

        return this.service.removePerson(id);

    }

    @PatchMapping("/update/{id}")
    public Person updatePerson(@PathVariable int id,
                               @RequestParam(name="name", required = false) String name,
                               @RequestParam(name="age", required = false) Integer age,
                               @RequestParam(name="job", required = false) String job){


    return this.service.updatePerson(id, name, age, job);
    }

//    @PostMapping("/people/new")
//    public ResponseEntity<Person> createPeople(@RequestBody Person newPeople){
//        this.people.add(newPeople);
//        Person added = this.people.get(this.people.size()-1);
//        return new ResponseEntity<>(added, HttpStatus.CREATED);
//
//    }


}

