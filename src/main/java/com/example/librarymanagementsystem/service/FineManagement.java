package com.example.librarymanagementsystem.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.example.librarymanagementsystem.model.entity.BorrowedBook;
import com.example.librarymanagementsystem.model.repository.BorrowedBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FineManagement {
    @Autowired
    private BorrowedBookRepo BorrowedRepo;


    public double CalculateFIne(int UserID, String ISBN){
        BorrowedBook.BorrowedBookId borrowedBookId = new BorrowedBook.BorrowedBookId(ISBN, UserID);
        BorrowedBook borrowedBook = BorrowedRepo.findById(borrowedBookId).orElseThrow(() -> new IllegalArgumentException("No record found for the given ID."));

        LocalDate borrowDate = borrowedBook.getBorrowDate();
        LocalDate dueDate = borrowedBook.getDueDate();
        LocalDate currentDate = LocalDate.now();

        if (currentDate.isAfter(dueDate)) {
            long overdueDays = ChronoUnit.DAYS.between(dueDate, currentDate);
            return (20 + overdueDays * 2.5);
        }
        else return 0.0;
    }
}
