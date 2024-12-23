package com.example.librarymanagementsystem.model.dto;

public class BookDTO {
    private Integer stock;
    private BookDescriptionDTO description;
    private Boolean available;
    private String ISBN;

    public BookDTO() {}

    public BookDTO(String ISBN, Integer stock, BookDescriptionDTO description, Boolean available) {
        this.stock = stock;
        this.description = description;
        this.available = available;
        this.ISBN = ISBN;
    }

    public String getISBN(){ return ISBN; }

    public void setISBN(String ISBN){ this.ISBN = ISBN; }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
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