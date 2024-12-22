package com.example.librarymanagementsystem.model.dto;

public class UserDTO {
    private Integer ID;
    private String name;
    private int age;
    private String gender;
    private Integer frequency;

    public UserDTO() {}

    public UserDTO(Integer ID, String name, int age, String gender, Integer frequency) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.frequency = frequency;
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

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }
}

