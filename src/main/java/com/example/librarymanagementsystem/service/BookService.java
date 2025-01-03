package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.model.dto.BookDTO;
import com.example.librarymanagementsystem.model.dto.BookDescriptionDTO;
import com.example.librarymanagementsystem.model.entity.Book;
import com.example.librarymanagementsystem.model.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepository;
    @Autowired
    private BookDescriptionService bookDescriptionService;

    public List<BookDTO> getAny7Books(int n) {
        List<Book> books = bookRepository.findAll(PageRequest.of(0, n-1)).getContent();
        return books.stream()
                .map(BookDTO::toDto)
                .collect(Collectors.toList());
    }
    //To be modified
    public List<Map<String, Object>> getBookAndDescription() {
        List<Book> books = this.bookRepository.findAll(PageRequest.of(0, 7)).getContent();
        List<Map<String, Object>> booksWithDescription = new ArrayList<>();
        for (Book book : books) {
            String ISBN = book.getId();
            BookDescriptionDTO bookDescriptionDTO = bookDescriptionService.getDescription(ISBN);
            System.out.println(bookDescriptionDTO.getISBN());
            Map<String, Object> details = new HashMap<>();
            details.put("book", book);
            details.put("description", bookDescriptionDTO.getSummary());
            details.put("title", bookDescriptionDTO.getTitle());
            booksWithDescription.add(details);
        }
        return booksWithDescription;
    }

    public Map<String, Object> getBookAndDescriptionByISBN(String ISBN) {
        // Fetch the book by its ISBN
        if (ISBN == null) {
            return null;
        }
        Book book = this.bookRepository.findByISBN(ISBN);

        if (book == null) {
            return Collections.emptyMap();
        }
        BookDescriptionDTO bookDescriptionDTO = bookDescriptionService.getDescription(ISBN);

        Map<String, Object> details = new HashMap<>();
        details.put("book", book);
        details.put("title", bookDescriptionDTO.getTitle());
        details.put("summary", bookDescriptionDTO.getSummary());
        details.put("author", bookDescriptionDTO.getAuthor());
        details.put("genre", bookDescriptionDTO.getGenre());
        details.put("pages", bookDescriptionDTO.getPages());
        details.put("publisher", bookDescriptionDTO.getPublisher());
        details.put("date", bookDescriptionDTO.getPublicationDate());
        return details;
    }
    // Create or update a book
    public BookDTO saveOrUpdateBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setId(bookDTO.getISBN());
        book.setStock(bookDTO.getStock());
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
        Book book = bookRepository.findById(Integer.valueOf(ISBN)).orElseThrow(() -> new IllegalArgumentException("Book not found with ISBN: " + ISBN));
        return BookDTO.toDto(book);
    }

    // Delete a book by ISBN
    public void deleteBook(String ISBN) {
        if (!bookRepository.existsById(Integer.valueOf(ISBN))) {
            throw new IllegalArgumentException("Book not found with ISBN: " + ISBN);
        }
        bookRepository.deleteById(Integer.valueOf(ISBN));
    }

    // Update the stock of a book
    public BookDTO updateStock(String ISBN, int newStock) {
        Book book = bookRepository.findById(Integer.valueOf(ISBN)).orElseThrow(() -> new IllegalArgumentException("Book not found with ISBN: " + ISBN));
        book.setStock(newStock);
        book.setAvailable(newStock > 0); // Update availability based on stock
        Book updatedBook = bookRepository.save(book);
        return BookDTO.toDto(updatedBook);
    }

}
