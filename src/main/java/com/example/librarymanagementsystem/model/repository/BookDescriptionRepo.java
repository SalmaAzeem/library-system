package com.example.librarymanagementsystem.model.repository;

import com.example.librarymanagementsystem.model.entity.Book;
import com.example.librarymanagementsystem.model.entity.BookDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDescriptionRepo extends JpaRepository<BookDescription, String>{
    List<BookDescription> findByTitle(String title);
    List<BookDescription> findByAuthor(String author);
    List<BookDescription> findByGenre(String genre);
}
