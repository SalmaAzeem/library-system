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
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<BorrowedBook> borrowedBooks = new ArrayList<>();
    public User() { super();}

    public User(String name, int age, String gender, int frequency) {
        super(name, age, gender);
        this.Frequency = frequency;
    }
    public Integer getID() { return ID; }
    public void setID(Integer ID) { this.ID = ID; }
    public int getFrequency() { return Frequency; }
    public void setFrequency(int Frequency) { this.Frequency = Frequency; }
    public List<BorrowedBook> getBorrowedBooks() { return borrowedBooks; }
    public void setBorrowedBooks(List<BorrowedBook> borrowedBooks) { this.borrowedBooks = borrowedBooks; }
    public void addBorrowedBook(BorrowedBook borrowedBook) {
        borrowedBooks.add(borrowedBook);
        borrowedBook.setUser(this);
    }

    public void removeBorrowedBook(BorrowedBook borrowedBook) {
        borrowedBooks.remove(borrowedBook);
        borrowedBook.setUser(null);
    }

}
