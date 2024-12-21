package com.example.LibraryManagementSystem.model.entity;

import jakarta.persistence.*;

@Table(name="users")
@Entity
public class User extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    @Column(name="frequency")
    private Integer Frequency;
//    private BookList BorrowedList = new BookList();
//    private BookList readingList;
    public User() {}

    public Integer getID() { return ID; }
    public void setID(Integer ID) { this.ID = ID; }
    public Integer getFrequency() { return Frequency; }
    public void setFrequency(Integer Frequency) { this.Frequency = Frequency; }
}
