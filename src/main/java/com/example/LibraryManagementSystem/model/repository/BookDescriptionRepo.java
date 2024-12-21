package com.example.LibraryManagementSystem.model.repository;

import com.example.LibraryManagementSystem.model.entity.BookDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDescriptionRepo extends JpaRepository<BookDescription, Integer>{

}
