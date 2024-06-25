package com.qa.rest;

import com.qa.domain.Cat;
import com.qa.service.CatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
// controllers handle requests
@RestController
public class CatController {

    private CatService service;

    public CatController(CatService service) {
        this.service = service;
    }

    // this method will be called when a GET request is sent to /hello
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @PostMapping("/cat/new")
    public ResponseEntity<Cat> createCat(@RequestBody Cat newCat) {
        return this.service.createCat(newCat);
    }

    @GetMapping("/cat/all")
    public List<Cat> getAll() {
        return this.service.getAll();
    }

    @GetMapping("/cat/{id}")
    public ResponseEntity<?> getCat(@PathVariable Integer id) {
        return this.service.getCat(id);
    }


    @PatchMapping("/cat/{id}")
    public ResponseEntity<?> updateCat(@PathVariable(name = "id") Integer id,
                                       @RequestParam(name = "name", required = false) String name,
                                       @RequestParam(name = "colour", required = false) String colour,
                                       @RequestParam(name = "age", required = false) Integer age,
                                       @RequestParam(name = "nature", required = false) String nature,
                                       @RequestParam(name = "lives", required = false) Integer lives) {
        return this.service.updateCat(id, name, colour, age, nature, lives);
    }

    @DeleteMapping("/cat/{id}")
    public ResponseEntity<?> removeCat(@PathVariable Integer id) {
        return this.service.removeCat(id);
    }
}