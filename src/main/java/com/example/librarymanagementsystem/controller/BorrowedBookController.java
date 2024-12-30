package com.example.librarymanagementsystem.controller;



import com.example.librarymanagementsystem.model.dto.BorrowedBookDTO;
import com.example.librarymanagementsystem.model.dto.ReservedBookDTO;
import com.example.librarymanagementsystem.model.entity.ReservedBook;
import com.example.librarymanagementsystem.service.BorrowService;

import com.example.librarymanagementsystem.service.FineManagement;
import com.example.librarymanagementsystem.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Controller class for managing the book list in the library.
 */

@Controller
@RequestMapping("/borrowed-books")
public class BorrowedBookController {

    @Autowired
    private BorrowService borrowedBookService;
    @Autowired
    private FineManagement fineManager;
    @Autowired
    private ReserveService reserveService;

    @GetMapping("/user")
    public String getBooksAndFinesByUser(@RequestParam("userID") Integer userID, Model model) {
        if (userID == null) {
            model.addAttribute("errorMessage", "User ID is required.");
            return "error";
        }
        System.out.println("Fetching data for userID: " + userID);
        List<BorrowedBookDTO> borrowedBooks = borrowedBookService.getBorrowedBooksByUserID(userID);
        model.addAttribute("userID", userID);
        model.addAttribute("borrowedBooks", borrowedBooks);
        List<BorrowedBookDTO> fineDetails = borrowedBookService.getBorrowedBooksByUserID(userID);
        model.addAttribute("fineDetails", fineDetails);
        List<ReservedBookDTO> reservedBooks = reserveService.getReservedBooksbyUserID(userID);
        model.addAttribute("reservedBooks", reservedBooks);
        return "borrowed_books";
    }
}
