package com.qa.domain;
//
import jakarta.persistence.*;

//
@Entity // flags the class as a db entity
public class Cat {

    @Id // flags the field as a PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // makes the field AUTO_INCREMENT
    private Integer id;

    private String name;

    private String colour;

    private int age;

    private String nature;

    private int lives;

    // REQUIRED
    public Cat() {
        super();
    }

    public Cat(Integer id, String name, String colour, int age, String nature, int lives) {
        this.id = id;
        this.name = name;
        this.colour = colour;
        this.age = age;
        this.nature = nature;
        this.lives = lives;
    }
    // REQUIRED
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                ", age=" + age +
                ", nature='" + nature + '\'' +
                ", lives=" + lives +
                '}';
    }
}