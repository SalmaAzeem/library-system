package com.project.repository;
import com.project.model.BookList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  BookListRepository extends JpaRepository<BookList, Integer> {

}
