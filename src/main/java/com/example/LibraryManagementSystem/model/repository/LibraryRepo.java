package com.example.librarymanagementsystem.model.repository;

import com.example.librarymanagementsystem.model.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepo extends JpaRepository<Library, Integer> {

}
