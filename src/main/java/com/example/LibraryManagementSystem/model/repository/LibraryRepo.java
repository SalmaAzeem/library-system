package com.example.LibraryManagementSystem.model.repository;

import com.example.LibraryManagementSystem.model.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepo extends JpaRepository<Library, Integer> {

}
