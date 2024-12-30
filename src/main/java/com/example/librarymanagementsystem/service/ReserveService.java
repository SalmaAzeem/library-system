package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.model.dto.BookDTO;
import com.example.librarymanagementsystem.model.dto.ReservedBookDTO;
import com.example.librarymanagementsystem.model.dto.UserDTO;
import com.example.librarymanagementsystem.model.entity.*;
import com.example.librarymanagementsystem.model.repository.BookDescriptionRepo;
import com.example.librarymanagementsystem.model.repository.ReservedBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service

public class ReserveService {

    @Autowired
    private ReservedBookRepo ReserveRepo;
    @Autowired
    private BookService Bookservice;
    @Autowired
    private BookDescriptionRepo bookDescriptionRepo;

    public void reserveBook(UserDTO user, BookDTO book) {
        // Check if the book is in stock
        BookDTO booktoReserve = Bookservice.getBookByISBN(book.getISBN());
        if (!booktoReserve.getAvailable() || booktoReserve.getStock() < 0) {
            throw new IllegalStateException("This book is in stock, no need to reserve.");
        }
        // Create and save the ReservedBook record
        ReservedBook reservedBook = new ReservedBook(book.getISBN(), user.getID());
        ReserveRepo.save(reservedBook);
    }

    public List<ReservedBookDTO> getReservedBooksbyUserID(Integer userID) {
        return ReserveRepo.findAllByUserID(userID)
                .stream()
                .map(reservedBook -> {
                    // Fetch book title using ISBN
                    String bookTitle = bookDescriptionRepo.findById(reservedBook.getISBN())
                            .map(BookDescription::getTitle)
                            .orElse("Unknown Title");

                    // Convert to DTO with additional field
                    return ReservedBookDTO.toDto(reservedBook, bookTitle);
                })
                .collect(Collectors.toList());
    }

}
