package com.project.model;

import java.util.List;

public abstract class Person {
    private String name;
    private int age;
    private String gender;

     Person() {
        name="Unknown";
        age=0;
        gender="Not specified";
    }

     Person(String name, int age, String gender) {
        this.name = name;
        this.age=age;
        this.gender=gender;
    }
    abstract List<String> ShowInfo();
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
