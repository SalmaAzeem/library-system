package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.model.dto.BorrowedBookDTO;
import com.example.librarymanagementsystem.model.dto.ReservedBookDTO;
import com.example.librarymanagementsystem.service.BorrowService;
import com.example.librarymanagementsystem.service.FineManagement;
import com.example.librarymanagementsystem.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/borrowed-books")
@SessionAttributes("loggedInUserID")
public class BorrowedBookController {

    @Autowired
    private BorrowService borrowedBookService;

    @Autowired
    private FineManagement fineManager;

    @Autowired
    private ReserveService reserveService;

    @GetMapping
    public String getBooksAndFinesByUser(@SessionAttribute("loggedInUserID") Integer userID, Model model) {
        if (userID == null) {
            model.addAttribute("errorMessage", "User ID is required.");
            return "error";
        }

        System.out.println("Fetching data for userID: " + userID);

        // Fetch borrowed books
        List<BorrowedBookDTO> borrowedBooks = borrowedBookService.getBorrowedBooksByUserID(userID);
        model.addAttribute("borrowedBooks", borrowedBooks);

        // Fetch fine details
        List<BorrowedBookDTO> fineDetails = borrowedBookService.getBorrowedBooksByUserID(userID);
        model.addAttribute("fineDetails", fineDetails);

        // Fetch reserved books
        List<ReservedBookDTO> reservedBooks = reserveService.getReservedBooksbyUserID(userID);
        model.addAttribute("reservedBooks", reservedBooks);

        model.addAttribute("userID", userID);

        return "borrowed_books";
    }
}
