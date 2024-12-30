package com.example.librarymanagementsystem.service;
import com.example.librarymanagementsystem.model.dto.BookDTO;
import com.example.librarymanagementsystem.model.entity.Book;
import com.example.librarymanagementsystem.model.repository.BookDescriptionRepo;
import com.example.librarymanagementsystem.model.dto.BookDescriptionDTO;
import com.example.librarymanagementsystem.model.entity.BookDescription;
import com.example.librarymanagementsystem.model.repository.BookDescriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class BookDescriptionService {
    @Autowired
    private BookDescriptionRepo bookDescriptionRepo;
    public BookDescriptionDTO getDescription(String ISBN) {
        Optional<BookDescription> bookDescription = this.bookDescriptionRepo.findById(ISBN);
        return bookDescription.map(BookDescriptionDTO::toDto).orElse(null);
    }

    public void DeleteBookDescription(String ISBN) {
        this.bookDescriptionRepo.deleteById(ISBN);
    }

    public void saveBookDescription(BookDescriptionDTO bookDescriptionDTO) {
        if (bookDescriptionDTO.getISBN() != null) {
            BookDescription bookDescription = this.bookDescriptionRepo.findById(bookDescriptionDTO.getISBN())
                    .orElseThrow(() -> new RuntimeException("Book description not found."));
            bookDescription.setAuthor(bookDescriptionDTO.getAuthor());
            bookDescription.setGenre(bookDescriptionDTO.getGenre());
            bookDescription.setPages(bookDescriptionDTO.getPages());
            bookDescription.setPublisher(bookDescriptionDTO.getPublisher());
            bookDescription.setPublicationDate(bookDescriptionDTO.getPublicationDate());
            bookDescription.setSummary(bookDescriptionDTO.getSummary());
            bookDescription.setTableOfContents(bookDescriptionDTO.getTableOfContents());
            bookDescription.setTitle(bookDescriptionDTO.getTitle());
        } else {
            throw new IllegalArgumentException("Can't update the book description without an ISBN.");
        }
    }
    public void updateBookDescription(BookDescriptionDTO bookDescriptionDTO) {
        if (bookDescriptionDTO.getISBN() != null) {
            BookDescription bookDescription = this.bookDescriptionRepo.findById(bookDescriptionDTO.getISBN())
                    .orElseThrow(() -> new RuntimeException("Book description not found."));
            bookDescription.setAuthor(bookDescriptionDTO.getAuthor());
            bookDescription.setGenre(bookDescriptionDTO.getGenre());
            bookDescription.setPages(bookDescriptionDTO.getPages());
            bookDescription.setPublisher(bookDescriptionDTO.getPublisher());
            bookDescription.setPublicationDate(bookDescriptionDTO.getPublicationDate());
            bookDescription.setSummary(bookDescriptionDTO.getSummary());
            bookDescription.setTableOfContents(bookDescriptionDTO.getTableOfContents());
            bookDescription.setTitle(bookDescriptionDTO.getTitle());
        } else {
            throw new IllegalArgumentException("Can't update the book description without an ISBN.");
        }
    }
    public List<BookDescriptionDTO> searchBooksByTitle(String title) {
        List<BookDescription> books = bookDescriptionRepo.findByTitle(title);
        return books.stream()
                .map(BookDescriptionDTO::toDto)
                .collect(Collectors.toList());
    }

    public List<BookDescriptionDTO> searchBooksByAuthor(String author) {
        List<BookDescription> books = bookDescriptionRepo.findByAuthor(author);
        return books.stream()
                .map(BookDescriptionDTO::toDto)
                .collect(Collectors.toList());
    }

    public List<BookDescriptionDTO> categorize(String genre) {
        List<BookDescription> books = bookDescriptionRepo.findByGenre(genre);
        return books.stream()
                .map(BookDescriptionDTO::toDto)
                .collect(Collectors.toList());
    }
}
