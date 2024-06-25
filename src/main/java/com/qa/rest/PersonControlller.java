package com.qa.rest;


import com.qa.entities.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonControlller {

    private List<Person> people = new ArrayList<>();

    @GetMapping("/getAll")
    public List<Person> getAll() {

        return this.people;
    }
    @PostMapping("/create")
    public Person createPerson(@RequestBody Person person){

        this.people.add(person);

        return this.people.get(this.people.size() - 1);

    }

    @DeleteMapping("/remove/{id}")
    public Person removePerson(@PathVariable int id){
        Person toRemove = this.people.get(id);
        return this.people.remove(id);

    }

    @PatchMapping("/update/{id}")
    public Person updatePerson(@PathVariable int id,
                               @RequestParam(name="name", required = false) String name,
                               @RequestParam(name="age", required = false) Integer age,
                               @RequestParam(name="job", required = false) String job){
    Person toUpdate = this.people.get(id);

    if (name != null) toUpdate.setName(name);
    if (age != null) toUpdate.setAge(age);
    if (job != null) toUpdate.setJob(job);

    return toUpdate;
    }

//    @PostMapping("/people/new")
//    public ResponseEntity<Person> createPeople(@RequestBody Person newPeople){
//        this.people.add(newPeople);
//        Person added = this.people.get(this.people.size()-1);
//        return new ResponseEntity<>(added, HttpStatus.CREATED);
//
//    }


}

