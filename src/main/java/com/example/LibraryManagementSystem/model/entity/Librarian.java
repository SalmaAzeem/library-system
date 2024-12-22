package com.example.librarymanagementsystem.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "librarian")
public class Librarian extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer employeeID;

    public Librarian() {
        super();
    }

    public Librarian(String name, int age, String gender) {
        super(name, age, gender);
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }
}

