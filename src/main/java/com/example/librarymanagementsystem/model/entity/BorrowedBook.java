package com.example.librarymanagementsystem.model.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;


    @Column(name = "borrow_date", nullable = false, updatable = false)
    private LocalDate borrowDate;

    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    // Constructors
    public BorrowedBook() {
        // Initialize borrowDate and dueDate automatically
        this.borrowDate = LocalDate.now();
        this.dueDate = this.borrowDate.plus(2, ChronoUnit.WEEKS);
    }

    public BorrowedBook(String ISBN, Integer userID) {
        this.ISBN = ISBN;
        this.userID = userID;
        this.borrowDate = LocalDate.now();
        this.dueDate = this.borrowDate.plus(2, ChronoUnit.WEEKS);
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
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
