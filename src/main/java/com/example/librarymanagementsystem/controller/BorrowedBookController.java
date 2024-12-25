package com.example.librarymanagementsystem.controller;



import com.example.librarymanagementsystem.model.dto.BorrowedBookDTO;
import com.example.librarymanagementsystem.service.BorrowService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for managing the book list in the library.
 */

@Controller
@RequestMapping("/borrowed-books")
public class BorrowedBookController {

    @Autowired
    private BorrowService borrowedBookService;

    @GetMapping("/user")
    public String getBorrowedBooksByUser(@RequestParam Integer userID, Model model) {
        List<BorrowedBookDTO> borrowedBooks = borrowedBookService.getBorrowedBooksByUserID(userID);
        model.addAttribute("userID", userID);
        model.addAttribute("borrowedBooks", borrowedBooks);
        return "borrowed_books";
    }
}
