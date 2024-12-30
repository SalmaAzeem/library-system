package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.service.LibrarianService;

/**
 * Controller class for managing the librarian info.
 */

public class LibrarianController {
    private LibrarianService librarianService;

    public LibrarianController(LibrarianService librarianService) {
        this.librarianService = librarianService;
    }
}
