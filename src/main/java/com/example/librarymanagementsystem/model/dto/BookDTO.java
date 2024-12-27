package com.example.librarymanagementsystem.model.dto;

import com.example.librarymanagementsystem.model.entity.Book;
import com.example.librarymanagementsystem.model.entity.BookDescription;

public class BookDTO {
    private int stock;
    private BookDescriptionDTO description;
    private Boolean available;
    private String ISBN;

    public BookDTO() {}

    public BookDTO(int stock, BookDescriptionDTO description, Boolean available, String ISBN) {
        this.stock = stock;
        this.description = description;
        this.available = available;
        this.ISBN = ISBN;
    }

    public BookDTO(String ISBN, int stock, Boolean available) {
        this.stock = stock;
        this.available = available;
        this.ISBN = ISBN;
    }
    public static BookDTO toDto(Book entity) {
        return new BookDTO(entity.getId(), entity.getStock(), entity.getAvailable());
    }
    public String getISBN(){ return ISBN; }

    public void setISBN(String ISBN){ this.ISBN = ISBN; }

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