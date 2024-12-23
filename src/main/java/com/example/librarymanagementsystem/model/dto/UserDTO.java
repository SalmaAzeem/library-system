package com.example.librarymanagementsystem.model.dto;

import com.example.librarymanagementsystem.model.entity.User;

public class UserDTO {
    private Integer ID;
    private String name;
    private int age;
    private String gender;
    private int frequency;

    public UserDTO() {}

    public UserDTO(Integer ID, String name, int age, String gender, int frequency) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.frequency = frequency;
    }

    public static UserDTO toDTo(User entity) {
        return new UserDTO(entity.getID(), entity.getName(), entity.getAge(), entity.getGender(), entity.getFrequency());
    }

    // Getters and Setters

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

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

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}

