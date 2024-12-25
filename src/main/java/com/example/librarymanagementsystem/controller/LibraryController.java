package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.service.LibraryService;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for managing the library.
 */
@RestController
public class LibraryController {
    private LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }
}
