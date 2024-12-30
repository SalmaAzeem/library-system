package com.example.librarymanagementsystem.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import com.example.librarymanagementsystem.model.dto.BookDTO;
import com.example.librarymanagementsystem.model.dto.BorrowedBookDTO;
import com.example.librarymanagementsystem.model.entity.Book;
import com.example.librarymanagementsystem.model.entity.BorrowedBook;
import com.example.librarymanagementsystem.model.entity.User;
import com.example.librarymanagementsystem.model.repository.BookDescriptionRepo;
import com.example.librarymanagementsystem.model.repository.BorrowedBookRepo;
import com.example.librarymanagementsystem.model.entity.BookDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowService {
    @Autowired
    private BorrowedBookRepo borrowedBookRepo;
    @Autowired
    private BookDescriptionRepo bookDescriptionRepo;
    @Autowired
    private BookService Bookservice;
    @Autowired
    private FineManagement fineservice;

    public void borrowBook(User user, Book book) {
        // Check if the book is in stock
        BookDTO BooktoBorrow = Bookservice.getBookByISBN(book.getId());
        if (!(BooktoBorrow.getAvailable() && BooktoBorrow.getStock()>0)) {
            throw new IllegalStateException("This book is not in stock.");
        }
        // Create and save the BorrowedBook record
        BorrowedBook borrowedBook = new BorrowedBook(book.getId(), user.getID());
        borrowedBookRepo.save(borrowedBook);
        user.getBorrowedBooks().add(borrowedBook);
    }

    public List<BorrowedBookDTO> getBorrowedBooksByUserID(Integer userID) {
    return borrowedBookRepo.findAllByUserID(userID)
            .stream()
            .map(borrowedBook -> {
                // Fetch the book title using ISBN
                String bookTitle = bookDescriptionRepo.findById(borrowedBook.getISBN())
                        .map(BookDescription::getTitle)
                        .orElse("Unknown Title");

                // Calculate late days
                long lateDays = Math.max(0, ChronoUnit.DAYS.between(borrowedBook.getDueDate(), LocalDate.now()));

                // Calculate fine based on late days
                double fine = fineservice.calculateFine(userID, borrowedBook.getISBN());

                // Convert to DTO with additional fields
                return BorrowedBookDTO.toDto(borrowedBook, fine, lateDays, bookTitle);
            })
            .collect(Collectors.toList());
}


}
