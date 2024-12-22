package com.example.librarymanagementsystem.model.repository;

import com.example.librarymanagementsystem.model.entity.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowedBookRepo extends JpaRepository<BorrowedBook, Integer> {

}
