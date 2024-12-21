package com.example.LibraryManagementSystem.model.dto;

public class LibrarianDTO {
    private Integer employeeID;
    private String name;
    private int age;
    private String gender;

    public LibrarianDTO() {}

    public LibrarianDTO(Integer employeeID, String name, int age, String gender) {
        this.employeeID = employeeID;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
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
}
