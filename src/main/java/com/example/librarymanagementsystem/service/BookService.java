package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.model.dto.BookDTO;
import com.example.librarymanagementsystem.model.entity.Book;
import com.example.librarymanagementsystem.model.repository.BookRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepository;


    // Create or update a book
    public BookDTO saveOrUpdateBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setId(bookDTO.getISBN());
        book.setStock(bookDTO.getStock());
        book.setDescription(bookDTO.getDescription());
        book.setAvailable(bookDTO.getAvailable());

        Book savedBook = bookRepository.save(book);
        return BookDTO.toDto(savedBook);
    }

    // Fetch all books
    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(BookDTO::toDto)
                .collect(Collectors.toList());
    }

    // Fetch a book by ISBN
    public BookDTO getBookByISBN(String ISBN) {
        Book book = bookRepository.findById(ISBN).orElseThrow(() -> new IllegalArgumentException("Book not found with ISBN: " + ISBN));
        return BookDTO.toDto(book);
    }

    // Delete a book by ISBN
    public void deleteBook(String ISBN) {
        if (!bookRepository.existsById(ISBN)) {
            throw new IllegalArgumentException("Book not found with ISBN: " + ISBN);
        }
        bookRepository.deleteById(ISBN);
    }

    // Update the stock of a book
    public BookDTO updateStock(String ISBN, int newStock) {
        Book book = bookRepository.findById(ISBN).orElseThrow(() -> new IllegalArgumentException("Book not found with ISBN: " + ISBN));
        book.setStock(newStock);
        book.setAvailable(newStock > 0); // Update availability based on stock
        Book updatedBook = bookRepository.save(book);
        return BookDTO.toDto(updatedBook);
    }
}
