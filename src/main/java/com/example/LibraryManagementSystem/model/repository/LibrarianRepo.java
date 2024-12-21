package com.example.LibraryManagementSystem.model.repository;

import com.example.LibraryManagementSystem.model.entity.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrarianRepo extends JpaRepository<Librarian, Integer> {

}
