package com.example.librarymanagementsystem.model.dto;

import com.example.librarymanagementsystem.model.entity.BorrowedBook;

public class BorrowedBookDTO {
    private String ISBN;
    private Integer userID;
    private double fine;

    // Default Constructor
    public BorrowedBookDTO() {}

    public BorrowedBookDTO(String ISBN, Integer userID, double fine) {
        this.ISBN = ISBN;
        this.userID = userID;
        this.fine = fine;
    }

    public static BorrowedBookDTO toDto(BorrowedBook entity) {
        return new BorrowedBookDTO(entity.getISBN(), entity.getUserID(), entity.getFine());
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

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }
}
