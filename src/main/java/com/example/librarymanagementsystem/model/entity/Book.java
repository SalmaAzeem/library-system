package com.example.librarymanagementsystem.model.entity;

import com.example.librarymanagementsystem.model.dto.BookDescriptionDTO;
import com.example.librarymanagementsystem.model.entity.BookDescription;
import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ISBN")
    private String ISBN;

    @Column(name = "stock")
    private int stock;

    @Transient
    private BookDescriptionDTO description;

    @Column(name = "available")
    private Boolean available;

    public Book() {}

    public String getId() {
        return ISBN;
    }

    public void setId(String id) {
        this.ISBN = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public BookDescriptionDTO getDescription() {
        return description;
    }

    public void setDescription(BookDescriptionDTO description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}