package com.example.librarymanagementsystem.model.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Table(name = "borrowed_book")
@Entity
@IdClass(BorrowedBook.BorrowedBookId.class)
public class BorrowedBook {

    @Id
    @Column(name = "book_id")
    private String ISBN;

    @Id
    @Column(name = "user_id")
    private Integer userID;

    @ManyToOne
    @JoinColumn(name = "book_id", insertable = false, updatable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    // Constructors, Getters, and Setters
    public BorrowedBook() {}

    public BorrowedBook(Integer ISBN, Integer userID) {
        this.ISBN = ISBN;
        this.userID = userID;
    }

    public Integer getISBN() {
        return ISBN;
    }

    public void setISBN(Integer ISBN) {
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

    // Composite Key Class
    public static class BorrowedBookId implements Serializable {
        private Integer ISBN;
        private Integer userID;

        public BorrowedBookId() {}

        public BorrowedBookId(Integer ISBN, Integer userID) {
            this.ISBN = ISBN;
            this.userID = userID;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            BorrowedBookId that = (BorrowedBookId) o;
            return ISBN.equals(that.ISBN) && userID.equals(that.userID);
        }

        @Override
        public int hashCode() {
            return ISBN.hashCode() + userID.hashCode();
        }
    }
}
