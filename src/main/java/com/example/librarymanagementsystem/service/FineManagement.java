package com.example.librarymanagementsystem.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.librarymanagementsystem.model.entity.BorrowedBook;
import com.example.librarymanagementsystem.model.repository.BorrowedBookRepo;
import com.example.librarymanagementsystem.model.repository.BookDescriptionRepo;
import com.example.librarymanagementsystem.model.entity.BookDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FineManagement {
    @Autowired
    private BorrowedBookRepo borrowedBookRepo;

    @Autowired
    private BookDescriptionRepo bookDescriptionRepo;

    public double calculateFine(int userID, String ISBN) {
        BorrowedBook.BorrowedBookId borrowedBookId = new BorrowedBook.BorrowedBookId(ISBN, userID);
        BorrowedBook borrowedBook = borrowedBookRepo.findById(borrowedBookId)
                .orElseThrow(() -> new IllegalArgumentException("No record found for the given ID."));

        LocalDate dueDate = borrowedBook.getDueDate();
        LocalDate currentDate = LocalDate.now();

        if (currentDate.isAfter(dueDate)) {
            long overdueDays = ChronoUnit.DAYS.between(dueDate, currentDate);
            return 20 + overdueDays * 2.5;
        }
        return 0.0;
    }

//    public List<Map<String, Object>> calculateFinesForUser(int userID) {
//        List<BorrowedBook> borrowedBooks = borrowedBookRepo.findAllByUserID(userID);
//        List<Map<String, Object>> fineDetails = new ArrayList<>();
//
//        for (BorrowedBook book : borrowedBooks) {
//            Map<String, Object> details = new HashMap<>();
//
//            // Fetch book title using ISBN
//            String bookTitle = bookDescriptionRepo.findById(book.getISBN())
//                    .map(BookDescription::getTitle)
//                    .orElse("Unknown Title");
//
//            details.put("bookTitle", bookTitle);
//            details.put("lateDays", Math.max(0, ChronoUnit.DAYS.between(book.getDueDate(), LocalDate.now())));
//            details.put("fine", calculateFine(userID, book.getISBN()));
//            fineDetails.add(details);
//        }
//
//        return fineDetails;
//    }
}
