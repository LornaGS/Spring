package com.qa.lbg.domain;

public class Cat {

    private String name;

    private String colour;

    private int age;

    private String nature;

    private int lives;

    public Cat() {
        super();
    }

    public Cat(String name, String colour, int age, String nature, int lives) {
        super();
        this.name = name;
        this.colour = colour;
        this.age = age;
        this.nature = nature;
        this.lives = lives;
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