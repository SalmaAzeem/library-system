package com.example.librarymanagementsystem.controller;
import com.example.librarymanagementsystem.service.BookDescriptionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for managing book descriptions.
 * This controller handles requests related to book descriptions in the library system.
 */
@Controller
public class BookDescriptionController {
    private BookDescriptionService bookDescriptionService;

    public BookDescriptionController(BookDescriptionService bookDescriptionService) {
        this.bookDescriptionService = bookDescriptionService;
    }
}
