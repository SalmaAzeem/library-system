package com.example.librarymanagementsystem.model.repository;

import com.example.librarymanagementsystem.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
    Page<Book> findAll(Pageable pageable);
    Book findByISBN(String ISBN);
//    List<Book> findByTitle(String title);
//    List<Book> findByAuthor(String author);
//    List<Book> findByGenre(String genre);

}
