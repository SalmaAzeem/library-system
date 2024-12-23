package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.model.repository.BorrowedBookRepo;
import org.springframework.stereotype.Service;

@Service
public class FineManagement {
    private final BorrowedBookRepo BorrowedRepo;

    public FineManagement(BorrowedBookRepo Repo) {
        this.BorrowedRepo = Repo;
    }

    public void CalculateFIne(int UserID, String ISBN){

    }
}
