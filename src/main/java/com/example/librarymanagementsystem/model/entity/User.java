package com.example.librarymanagementsystem.model.entity;

import com.example.librarymanagementsystem.model.dto.BookDTO;
import com.example.librarymanagementsystem.model.dto.BorrowedBookDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name="users")
@Entity
public class User extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    @Column(name="frequency")
    private int Frequency;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BorrowedBookDTO> borrowedBooks = new ArrayList<>();
    public User() { super();}

    public User(String name, int age, String gender, int frequency) {
        super(name, age, gender);
        this.Frequency = frequency;
    }
    public Integer getID() { return ID; }
    public void setID(Integer ID) { this.ID = ID; }
    public int getFrequency() { return Frequency; }
    public void setFrequency(int Frequency) { this.Frequency = Frequency; }
    public List<BorrowedBookDTO> getBorrowedBooks() { return borrowedBooks; }
    public void setBorrowedBooks(List<BorrowedBookDTO> borrowedBooks) { this.borrowedBooks = borrowedBooks; }
}
