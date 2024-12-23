package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.model.dto.BorrowedBookDTO;
import com.example.librarymanagementsystem.model.entity.Book;
import com.example.librarymanagementsystem.model.entity.BorrowedBook;
import com.example.librarymanagementsystem.model.entity.User;
import com.example.librarymanagementsystem.model.repository.BorrowedBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowService {
    @Autowired
    private BorrowedBookRepo borrowedBookRepo;

    public void borrowBook(User user, Book book) {
        BorrowedBook borrowedBook = new BorrowedBook(book.getId(), user.getID());
        borrowedBook.setUser(user);
        borrowedBookRepo.save(borrowedBook);

        user.getBorrowedBooks().add(borrowedBook);
    }

}
