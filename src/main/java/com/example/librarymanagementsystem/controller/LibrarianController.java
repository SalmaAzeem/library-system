package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.service.LibrarianService;
import org.springframework.stereotype.Controller;

/**
 * Controller class for managing the librarian info.
 */
@Controller
public class LibrarianController {
    private LibrarianService librarianService;

    public LibrarianController(LibrarianService librarianService) {
        this.librarianService = librarianService;
    }
}
