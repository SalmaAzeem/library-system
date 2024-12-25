package com.example.librarymanagementsystem.model.repository;

import com.example.librarymanagementsystem.model.entity.ReservedBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservedBookRepo extends JpaRepository<ReservedBook, ReservedBook.ReservedBookID> {
}
