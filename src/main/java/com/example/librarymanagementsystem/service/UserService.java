package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.model.dto.UserDTO;
import com.example.librarymanagementsystem.model.entity.User;
import com.example.librarymanagementsystem.model.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public List<UserDTO> getAllUsers() {
        return this.userRepo.findAll()
                .stream()
                .map(user -> new UserDTO(
                        user.getID(),
                        user.getName(),
                        user.getAge(),
                        user.getGender(),
                        user.getFrequency()
                ))
                .collect(Collectors.toList());
    }

    public UserDTO getUser(int ID) {
        Optional<User> user = this.userRepo.findById(ID);
        return user.map(UserDTO::toDTo).orElse(null);
    }

    public void DeleteUser(int ID) {
        this.userRepo.deleteById(ID);
    }

    public void saveUser(UserDTO userDTO) {
        if (userDTO.getID() != null) {
            User user = userRepo.findById(userDTO.getID())
                    .orElseThrow(() -> new RuntimeException("User not found."));
            user.setName(userDTO.getName());
            user.setAge(userDTO.getAge());
            user.setGender(userDTO.getGender());
            user.setFrequency(userDTO.getFrequency());
            userRepo.save(user);
        } else {
            User user = new User();
            user.setName(userDTO.getName());
            user.setAge(userDTO.getAge());
            user.setGender(userDTO.getGender());
            user.setFrequency(userDTO.getFrequency());
            userRepo.save(user);
        }
    }


    public void updateUser(UserDTO userDTO) {
        if (userDTO.getID() != null) {
            User user = userRepo.findById(userDTO.getID())
                    .orElseThrow(() -> new RuntimeException("User not found."));
            user.setName(userDTO.getName());
            user.setAge(userDTO.getAge());
            user.setGender(userDTO.getGender());
            user.setFrequency(userDTO.getFrequency());
        } else {
            throw new IllegalArgumentException("Can't update a user without an ID.");
        }
    }
}
