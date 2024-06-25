package com.qa.service;

import com.qa.entities.Person;
import com.qa.repos.PersonRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
//    private List<Person> people = new ArrayList<>();
private PersonRepo repo;

    public PersonService(PersonRepo repo) {
        this.repo = repo;
    }

//    public PersonService(List<Person> people) {
//        this.people = people;
//    }

    public List<Person> getAll() {
        return this.repo.findAll();

    }

    public Person get(int id) {return this.repo.findById(id).get();}


    public Person createPerson( Person person){

       return this.repo.save(person);

    }


    public Person removePerson( int id){
     Person removed = this.get(id);
     this.repo.deleteById(id);
     return removed;

    }


    public Person updatePerson( int id,
                               String name,
                               Integer age,
                              String job){
        Person toUpdate = this.get(id);

        if (name != null) toUpdate.setName(name);
        if (age != null) toUpdate.setAge(age);
        if (job != null) toUpdate.setJob(job);

    return this.repo.save(toUpdate);

    }


}
