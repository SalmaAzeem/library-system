package com.example.librarymanagementsystem.model.dto;

import com.example.librarymanagementsystem.model.entity.ReservedBook;

public class ReservedBookDTO {
    private String ISBN;
    private Integer userID;
    private String bookTitle; // New field

    // Default Constructor
    public ReservedBookDTO() {}

    // Parameterized Constructor
    public ReservedBookDTO(String ISBN, Integer userID, String bookTitle) {
        this.ISBN = ISBN;
        this.userID = userID;
        this.bookTitle = bookTitle;
    }

    // Overloaded toDto to include bookTitle
    public static ReservedBookDTO toDto(ReservedBook entity, String bookTitle) {
        return new ReservedBookDTO(
            entity.getISBN(),
            entity.getUserID(),
            bookTitle
        );
    }

    // Getters and Setters
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
}
