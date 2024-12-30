package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.model.dto.BookDTO;
import com.example.librarymanagementsystem.model.dto.BookDescriptionDTO;
import com.example.librarymanagementsystem.model.entity.Book;
import com.example.librarymanagementsystem.service.BookDescriptionService;
import com.example.librarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private final BookService bookService;
    private final BookDescriptionService bookDescriptionService;

    public BookController(BookService bookService, BookDescriptionService bookDescriptionService) {
        this.bookService = bookService;
        this.bookDescriptionService = bookDescriptionService;
    }


    @GetMapping("/any/{n}")
    public String getNBooks(@PathVariable int n, Model model) {
        List<Book> books = bookService.getAny7Books(n);
        model.addAttribute("books", books);
        return "redirect:/LibrarianDashboard";
    }

    @GetMapping("/details")
    public String getBookAndDescription(Model model) {
        List<Map<String, Object>> bookDetails = bookService.getBookAndDescription();
        model.addAttribute("bookDetails", bookDetails);
        return "redirect:/LibrarianDashboard";
    }

    @PostMapping("/new")
    public String saveOrUpdateBook(@RequestBody BookDTO bookDTO) {
        bookService.saveOrUpdateBook(bookDTO);
        return "redirect:/LibrarianDashboard";
    }

    @GetMapping("/all")
    public String allBooks(Model model) {
        List<BookDTO> books = bookService.getAllBooks();
        model.addAttribute("allBooks", books);
        model.addAttribute("book", new BookDTO());
        return "redirect:/LibrarianDashboard";
    }

    @GetMapping("/ISBN/{ISBN}")
    public String getBookByISBN(@PathVariable String ISBN, Model model) {
        BookDTO book = bookService.getBookByISBN(ISBN);
        model.addAttribute("book", book);
        return "redirect:/LibrarianDashboard";
    }

    @GetMapping("/search")
    public String getByTitle(@RequestParam String title, Model model) {
        List<BookDescriptionDTO> books = bookDescriptionService.searchBooksByTitle(title);
        model.addAttribute("allBooks", books);
        return "redirect:/LibrarianDashboard";
    }

    @GetMapping("/delete/{ISBN}")
    public String deleteBook(@PathVariable String ISBN) {
        bookService.deleteBook(ISBN);
        return "redirect:/LibrarianDashboard";
    }

    @PostMapping("/stock/{ISBN}/{newStock}")
    public String updateStock(@PathVariable String ISBN, @PathVariable int newStock) {
        bookService.updateStock(ISBN, newStock);
        return "redirect:/LibrarianDashboard";
    }

    /**
     * Displays details of a specific book by ISBN.
     *
     * @param ISBN  The ISBN of the book to retrieve details for.
     * @param model The model to pass data to the view.
     * @return The name of the HTML template for the book details.
     */
    @GetMapping("/{ISBN}")
    public String bookInfo(@PathVariable String ISBN, Model model) {
        Map<String, Object> bookDetails = bookService.getBookAndDescriptionByISBN(ISBN);
        model.addAttribute("bookDetails", bookDetails);
        return "BookInfo"; // Template for the book details
    }
}
