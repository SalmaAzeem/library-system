package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.service.BookService;

/**
 * Controller class for managing books in the library system.
 */

public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

}
