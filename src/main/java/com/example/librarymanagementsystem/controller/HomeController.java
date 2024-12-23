package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.model.entity.Book;
import com.example.librarymanagementsystem.service.BookDescriptionService;
import com.example.librarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String home(Model model) {
        List<Map<String, Object>> booksWithDescription = bookService.getBookAndDescription();
        System.out.println(booksWithDescription.isEmpty());
        model.addAttribute("booksWithDescriptions", booksWithDescription);
        return "Home";
    }
}
