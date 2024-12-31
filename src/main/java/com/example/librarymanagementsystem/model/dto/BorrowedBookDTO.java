package com.example.librarymanagementsystem.model.dto;

import com.example.librarymanagementsystem.model.entity.BorrowedBook;

import java.time.LocalDate;

public class BorrowedBookDTO {
    private String ISBN;
    private Integer userID;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private double fine;      // Existing field
    private long lateDays;    // Existing field
    private String bookTitle; // New field

    // Default Constructor
    public BorrowedBookDTO() {}

    // Updated Parameterized Constructor
    public BorrowedBookDTO(String ISBN, Integer userID, LocalDate borrowDate, LocalDate dueDate, double fine, long lateDays, String bookTitle) {
        this.ISBN = ISBN;
        this.userID = userID;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.fine = fine;
        this.lateDays = lateDays;
        this.bookTitle = bookTitle;
    }

    // Overloaded toDto Method
    public static BorrowedBookDTO toDto(BorrowedBook entity, double fine, long lateDays, String bookTitle) {
        return new BorrowedBookDTO(
            entity.getISBN(),
            entity.getUserID(),
            entity.getBorrowDate(),
            entity.getDueDate(),
            fine,
            lateDays,
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

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public long getLateDays() {
        return lateDays;
    }

    public void setLateDays(long lateDays) {
        this.lateDays = lateDays;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
}
