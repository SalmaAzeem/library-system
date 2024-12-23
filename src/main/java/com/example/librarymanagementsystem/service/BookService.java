package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.model.entity.Book;
import com.example.librarymanagementsystem.model.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;
    public List<Book> getAny7Books() {
        return bookRepo.findAll(PageRequest.of(0, 7)).getContent();
    }

}
