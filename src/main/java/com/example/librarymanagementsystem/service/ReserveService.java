package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.model.dto.BookDTO;
import com.example.librarymanagementsystem.model.dto.ReservedBookDTO;
import com.example.librarymanagementsystem.model.entity.Book;
import com.example.librarymanagementsystem.model.entity.ReservedBook;
import com.example.librarymanagementsystem.model.entity.User;
import com.example.librarymanagementsystem.model.repository.ReservedBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class ReserveService {

    @Autowired
    private ReservedBookRepo ReserveRepo;
    @Autowired
    private BookService Bookservice;

    public void borrowBook(User user, Book book) {
        // Check if the book is in stock
        BookDTO BooktoBorrow = Bookservice.getBookByISBN(book.getId());
        if (!(BooktoBorrow.getAvailable() && BooktoBorrow.getStock()>0)) {
            throw new IllegalStateException("This book is not in stock.");
        }
        // Create and save the BorrowedBook record
        ReservedBook reservedBook = new ReservedBook(book.getId(), user.getID());
        ReserveRepo.save(reservedBook);
    }

    public List<ReservedBookDTO> getReservedBooksbyUserID(Integer userID) {
        return ReserveRepo.findAllByUserID(userID)
                .stream()
                .map(ReservedBookDTO::toDto)
                .collect(Collectors.toList());
    }
}
