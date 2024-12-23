package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.model.dto.BookDTO;
import com.example.librarymanagementsystem.model.entity.Book;
import com.example.librarymanagementsystem.model.entity.BorrowedBook;
import com.example.librarymanagementsystem.model.entity.User;
import com.example.librarymanagementsystem.model.repository.BorrowedBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowService {
    @Autowired
    private BorrowedBookRepo borrowedBookRepo;
    @Autowired
    private BookService Bookservice;

    public void borrowBook(User user, Book book) {
        // Check if the book is in stock
        BookDTO BooktoBorrow = Bookservice.getBookByISBN(book.getId());
        if (!(BooktoBorrow.getAvailable() && BooktoBorrow.getStock()>0)) {
            throw new IllegalStateException("This book is not in stock.");
        }
        // Create and save the BorrowedBook record
        BorrowedBook borrowedBook = new BorrowedBook(book.getId(), user.getID());
        borrowedBookRepo.save(borrowedBook);

        if (user.getBorrowedBooks() != null) {
            user.getBorrowedBooks().add(borrowedBook);
        }
    }
}
