package com.example.librarymanagementsystem.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name="book_list")
@Entity
public class BookList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "booklist_id")
    private List<Book> books = new ArrayList<>();

    public Integer getID() { return ID; }
    public void setID(Integer ID) { this.ID = ID; }
    public List<Book> getBooks() {
        return books;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
