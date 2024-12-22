package com.example.librarymanagementsystem.model.entity;

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
    public User() { super();}

    public User(String name, int age, String gender, Integer frequency) {
        super(name, age, gender);
        this.Frequency = frequency;
    }
    public Integer getID() { return ID; }
    public void setID(Integer ID) { this.ID = ID; }
    public Integer getFrequency() { return Frequency; }
    public void setFrequency(Integer Frequency) { this.Frequency = Frequency; }
}
