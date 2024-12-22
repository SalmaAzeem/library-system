package com.example.librarymanagementsystem.model.repository;

import com.example.librarymanagementsystem.model.entity.BookList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookListRepo extends JpaRepository<BookList, Integer> {

}
