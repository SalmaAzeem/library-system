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

    @GetMapping("/user/borrowed")
    public String getBorrowedBooksByUser(@RequestParam Integer userID, Model model) {
        List<BorrowedBookDTO> borrowedBooks = borrowedBookService.getBorrowedBooksByUserID(userID);
        model.addAttribute("userID", userID);
        model.addAttribute("borrowedBooks", borrowedBooks);
        List<Map<String, Object>> fineDetails = fineManager.calculateFinesForUser(userID);
        model.addAttribute("fineDetails", fineDetails);
        return "borrowed_books";
    }

    @GetMapping("/user/reserved")
    public String getReservedBooksByUser(@RequestParam("userID") Integer userID, Model model) {
        List<ReservedBookDTO> reservedBooks = reserveService.getReservedBooksbyUserID(userID);
        model.addAttribute("reservedBooks", reservedBooks);
        model.addAttribute("userID", userID);
        return "reserved_books";
    }

}
