package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

/**
 * Controller class for handling the homepage.
 */
@Controller
public class HomeController {

    @Autowired
    private BookService bookService;

    /**
     * Displays the homepage with the top 7 books.
     *
     * @param model The model to pass data to the view.
     * @return The name of the HTML template for the homepage.
     */
    @GetMapping("/")
    public String home(Model model) {
        // Fetch the top 7 books using the BookService
        List<Map<String, Object>> booksWithDescription = bookService.getBookAndDescription();
        model.addAttribute("booksWithDescriptions", booksWithDescription);
        return "Home"; // Template for the homepage
    }
}
