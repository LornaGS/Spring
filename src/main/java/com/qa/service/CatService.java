package com.qa.service;
import com.qa.domain.Cat;
import com.qa.repos.CatRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@Service
public class CatService {

    private CatRepo repo;

    public CatService(CatRepo repo) {
        this.repo = repo;
    }

    public ResponseEntity<Cat> createCat(Cat newCat) {
        Cat created = this.repo.save(newCat);

        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    public List<Cat> getAll() {
        return this.repo.findAll();
    }

    public ResponseEntity<?> getCat(Integer id) {
        if (!this.repo.existsById(id))
            return new ResponseEntity<>("No cat found with id: " + id, HttpStatus.NOT_FOUND);

        Cat found = this.repo.findById(id).get();
        // missing not found logic
        return ResponseEntity.ok(found);
    }

    public ResponseEntity<?> updateCat(Integer id,
                                       String name,
                                       String colour,
                                       Integer age,
                                       String nature,
                                       Integer lives) {
        if (!this.repo.existsById(id))
            return new ResponseEntity<>("No cat found with id: " + id, HttpStatus.NOT_FOUND);

        Cat toUpdate = this.repo.findById(id).get();

        if (name != null) toUpdate.setName(name);
        if (colour != null) toUpdate.setColour(colour);
        if (age != null) toUpdate.setAge(age);
        if (nature != null) toUpdate.setNature(nature);
        if (lives != null) toUpdate.setLives(lives);


        Cat updated = this.repo.save(toUpdate);

        return ResponseEntity.ok(updated);
    }

    public ResponseEntity<?> removeCat(Integer id) {
        if (!this.repo.existsById(id))
            return new ResponseEntity<>("No cat found with id: " + id, HttpStatus.NOT_FOUND);

        Cat found = this.repo.findById(id).get();

        this.repo.deleteById(id);

        return ResponseEntity.ok(found);
    }


}