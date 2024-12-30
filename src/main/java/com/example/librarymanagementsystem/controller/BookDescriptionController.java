package com.example.librarymanagementsystem.controller;
import com.example.librarymanagementsystem.service.BookDescriptionService;
/**
 * Controller for managing book descriptions.
 * This controller handles requests related to book descriptions in the library system.
 */
public class BookDescriptionController {
    private BookDescriptionService bookDescriptionService;

    public BookDescriptionController(BookDescriptionService bookDescriptionService) {
        this.bookDescriptionService = bookDescriptionService;
    }
}
