package com.example.LibraryManagementSystem.model.repository;

import com.example.LibraryManagementSystem.model.entity.BookList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class BookListRepository implements JpaRepository<BookList, Integer> {

}