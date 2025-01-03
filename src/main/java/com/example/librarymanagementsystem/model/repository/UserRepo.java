package com.example.librarymanagementsystem.model.repository;

import com.example.librarymanagementsystem.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
