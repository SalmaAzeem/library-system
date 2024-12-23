package com.example.librarymanagementsystem.model.dto;

import com.example.librarymanagementsystem.model.entity.Book;
import com.example.librarymanagementsystem.model.entity.User;

public class BorrowedBookDTO {
    private String ISBN;
    private Integer userID;
    private Book book;
    private User user;
    private Double fine;

    public BorrowedBookDTO() {}
    public BorrowedBookDTO(String ISBN, Integer UserID, Book book, User user, Double fine) {
        this.ISBN = ISBN;
        this.userID = UserID;
        this.book = book;
        this.user = user;
        this.fine = fine;
    }

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
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Double getFine() {
        return fine;
    }
    public void setFine(Double fine) {
        this.fine = fine;
    }
}
