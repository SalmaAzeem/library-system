package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.model.dto.BookDTO;
import com.example.librarymanagementsystem.model.entity.Book;
import com.example.librarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Map;

/**
 * Controller class for managing books in the library system.
 */
@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping
    public List<Book>  getNBooks(int n)
    {
        return bookService.getAny7Books(n);
    }
    @GetMapping
    List<Map<String, Object>> getBookAndDescription()
    {
        return bookService.getBookAndDescription();
    }
    @PostMapping
    public BookDTO saveOrUpdateBook(BookDTO bookDTO)
    {
        return bookService.saveOrUpdateBook(bookDTO);
    }
    @GetMapping
    public List<BookDTO> allBooks(Model model)
    {
       List<BookDTO> books= bookService.getAllBooks();
        model.addAttribute("allBooks", books);
        model.addAttribute("book", new BookDTO());
        return books;
    }
    @GetMapping
    public BookDTO getBookByISBN(@PathVariable String ISBN, Model model)
    {
        BookDTO book= bookService.getBookByISBN(ISBN);
        model.addAttribute("book", book);
        //model.addAttribute("newBook", new BookDTO());
        return book;
    }
    @GetMapping
    public void getByTitle(String title, Model model)
    {
        List<BookDTO> books= bookService.searchBooksByTitle(title);
        model.addAttribute("allBooks", books);
    }
    @GetMapping("/delete/ISBN")
    public void deleteBook(@PathVariable String ISBN)
    {
        bookService.deleteBook(ISBN);
    }
    @PostMapping
    public BookDTO updateStock(@PathVariable String ISBN,@PathVariable int newStock)
    {
        BookDTO book = bookService.updateStock(ISBN,newStock);
        return book;
    }

}
