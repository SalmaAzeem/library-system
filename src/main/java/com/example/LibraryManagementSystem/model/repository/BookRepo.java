package com.example.LibraryManagementSystem.model.repository;

import com.example.LibraryManagementSystem.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

}
