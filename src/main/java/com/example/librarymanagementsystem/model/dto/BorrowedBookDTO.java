package com.example.librarymanagementsystem.model.dto;

import com.example.librarymanagementsystem.model.entity.BorrowedBook;

import java.time.LocalDate;

public class BorrowedBookDTO {
    private String ISBN;
    private Integer userID;
    private LocalDate borrowDate;
    private LocalDate dueDate;

    // Default Constructor
    public BorrowedBookDTO() {}

    // Parameterized Constructor
    public BorrowedBookDTO(String ISBN, Integer userID, LocalDate borrowDate, LocalDate dueDate) {
        this.ISBN = ISBN;
        this.userID = userID;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
    }

    public static BorrowedBookDTO toDto(BorrowedBook entity) {
        return new BorrowedBookDTO(
            entity.getISBN(),
            entity.getUserID(),
            entity.getBorrowDate(),
            entity.getDueDate()
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

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
