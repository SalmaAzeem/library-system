package com.example.librarymanagementsystem.model.repository;

import java.util.List;

import com.example.librarymanagementsystem.model.entity.ReservedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservedBookRepo extends JpaRepository<ReservedBook, ReservedBook.ReservedBookID> {
    List<ReservedBook> findAllByUserID(Integer userID);
}
