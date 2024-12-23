package com.example.librarymanagementsystem.model.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Table(name = "borrowed_book")
@Entity
@IdClass(BorrowedBook.BorrowedBookId.class)
public class BorrowedBook {

    @Id
    @Column(name = "book_id", nullable = false)
    private String ISBN;

    @Id
    @Column(name = "user_id", nullable = false)
    private Integer userID;

    @Column(name = "fine", columnDefinition = "DOUBLE DEFAULT 0")
    private double fine;

    // Constructors
    public BorrowedBook() {}

    public BorrowedBook(String ISBN, Integer userID) {
        this.ISBN = ISBN;
        this.userID = userID;
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

    // Composite Key Class
    public static class BorrowedBookId implements Serializable {
        private String ISBN;
        private Integer userID;

        public BorrowedBookId() {}

        public BorrowedBookId(String ISBN, Integer userID) {
            this.ISBN = ISBN;
            this.userID = userID;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof BorrowedBookId)) return false;
            BorrowedBookId that = (BorrowedBookId) o;
            return Objects.equals(ISBN, that.ISBN) && Objects.equals(userID, that.userID);
        }

        @Override
        public int hashCode() {
            return Objects.hash(ISBN, userID);
        }
    }
}
