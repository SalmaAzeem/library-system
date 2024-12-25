package com.example.librarymanagementsystem.model.dto;

import com.example.librarymanagementsystem.model.entity.BorrowedBook;
import com.example.librarymanagementsystem.model.entity.ReservedBook;

import java.time.LocalDate;

public class ReservedBookDTO {
    private String ISBN;
    private Integer userID;

    // Default Constructor
    public ReservedBookDTO() {}

    // Parameterized Constructor
    public ReservedBookDTO(String ISBN, Integer userID) {
        this.ISBN = ISBN;
        this.userID = userID;
    }

    public static ReservedBookDTO toDto(ReservedBook entity) {
        return new ReservedBookDTO(
            entity.getISBN(),
            entity.getUserID()
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

}
