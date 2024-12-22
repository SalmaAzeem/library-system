package com.example.LibraryManagementSystem.model.entity;

import com.example.LibraryManagementSystem.model.dto.BookDescriptionDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ISBN")
    private Integer ISBN;

    @Column(name = "stock")
    private Integer stock;

    @Transient
    private BookDescription description;

    @Column(name = "available")
    private Boolean available;

    public Book() {}

    public Integer getId() {
        return ISBN;
    }

    public void setId(Integer id) {
        this.ISBN = id;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public BookDescription getDescription() {
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

}
