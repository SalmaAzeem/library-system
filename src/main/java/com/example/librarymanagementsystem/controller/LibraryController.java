package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.model.dto.BookDTO;
import com.example.librarymanagementsystem.model.dto.LibraryDTO;
import com.example.librarymanagementsystem.model.entity.Book;
import com.example.librarymanagementsystem.service.BookService;
import com.example.librarymanagementsystem.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.List;
import java.util.Map;

/**
 * Controller class for managing the library.
 */
@Controller
@RequestMapping("/LibrarianDashboard")
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @GetMapping("/LibrarianDashboard")
    public String displayInfo(Model model) {
        List<LibraryDTO> libraryDTOS = libraryService.getAllLibraries();
        model.addAttribute("libraryDTOS", libraryDTOS);
        return "Library";
    }

    @GetMapping("/LibrarianDashboard/books")
    public String displayBooks(Model model) {
        List<BookDTO> books = libraryService.getAllBooks();
        model.addAttribute("books", books);
        return "Books";
    }

    @GetMapping("/LibrarianDashboard/books/description")
    public String displayBooksWithDescription(Model model) {
        List<Map<String, Object>> booksWithDescription = libraryService.getBooksWithDescriptions();
        model.addAttribute("booksWithDescription", booksWithDescription);
        return "BooksWithDescription";
    }

    @GetMapping("/LibrarianDashboard/book/{ISBN}")
    public String displayBookDetails(@PathVariable String ISBN, Model model) {
        Map<String, Object> bookDetails = libraryService.getBookDetailsByISBN(ISBN);
        model.addAttribute("bookDetails", bookDetails);
        return "BookDetails";
    }

    @PostMapping("/LibrarianDashboard/book")
    public String saveOrUpdateBook(@ModelAttribute BookDTO bookDTO, Model model) {
        libraryService.saveOrUpdateBook(bookDTO);
        return "redirect:/LibrarianDashboard/books";
    }

    @GetMapping("/LibrarianDashboard/book/delete/{ISBN}")
    public String deleteBook(@PathVariable String ISBN) {
        libraryService.deleteBook(ISBN);
        return "redirect:/LibrarianDashboard/books";
    }

    @PostMapping("/LibrarianDashboard/book/update-stock")
    public String updateStock(@RequestParam String ISBN, @RequestParam int newStock, Model model) {
        libraryService.updateBookStock(ISBN, newStock);
        return "redirect:/LibrarianDashboard/books";
    }

    @GetMapping("/LibrarianDashboard/books/any")
    public String displayAnyNBooks(@RequestParam int n, Model model) {
        List<BookDTO> books = libraryService.getAnyNBooks(n);
        model.addAttribute("books", books);
        return "AnyNBooks";
    }
    @RequestMapping(value = "/LibrarianDashboard", method = RequestMethod.GET)
    public String showDashboard() {
        return "LibrarianDashboard";  // Returns the name of the HTML file without the extension
    }
}
