package com.example.librarymanagementsystem.model.repository;

import com.example.librarymanagementsystem.model.entity.BookDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDescriptionRepo extends JpaRepository<BookDescription, String>{
    BookDescription findByISBN(String ISBN);
}
