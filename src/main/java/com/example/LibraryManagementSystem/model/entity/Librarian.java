package com.example.LibraryManagementSystem.model.entity;

import jakarta.persistence.*;

@Table(name="librarian")
@Entity
public class Librarian extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer EmployeeID;

    public Librarian() {}
    public Integer getEmployeeID() { return EmployeeID; }
    public void setEmployeeID(Integer EmployeeID) { this.EmployeeID = EmployeeID; }
}
