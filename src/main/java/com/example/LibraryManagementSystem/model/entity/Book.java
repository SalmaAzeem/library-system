package com.example.LibraryManagementSystem.model.entity;

import com.example.LibraryManagementSystem.model.dto.BookDescriptionDTO;
import jakarta.persistence.*;
import org.hibernate.service.spi.InjectService;

@Table(name="books")
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="stock")
    private Integer Stock;
    private BookDescriptionDTO description;
    @Column(name="available")
    private Boolean Available;
    public Book() {}

    public Integer getStock() {
        return Stock;
    }
    public void setStock(Integer stock) {
        Stock = stock;
    }
    public BookDescriptionDTO getDescription() {
        return description;
    }
    public void setDescription(BookDescriptionDTO description) {
        this.description = description;
    }
    public Boolean isAvailable() {
        return Available;
    }
    public void setAvailable(Boolean available) {
        Available = available;
    }
}
