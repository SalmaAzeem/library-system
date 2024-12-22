package com.example.librarymanagementsystem.model.repository;

import com.example.librarymanagementsystem.model.entity.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrarianRepo extends JpaRepository<Librarian, Integer> {

}
