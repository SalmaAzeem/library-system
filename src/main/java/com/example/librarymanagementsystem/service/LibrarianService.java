package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.model.dto.LibrarianDTO;
import com.example.librarymanagementsystem.model.entity.Librarian;
import com.example.librarymanagementsystem.model.repository.LibrarianRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibrarianService {
    @Autowired
    private LibrarianRepo librarianRepo;
    public List<LibrarianDTO> getAllLibrarians() {
        return this.librarianRepo.findAll()
                .stream()
                .map(librarian -> new LibrarianDTO(
                        librarian.getEmployeeID(),
                        librarian.getName(),
                        librarian.getAge(),
                        librarian.getGender()
                ))
                .collect(Collectors.toList());
    }

    public LibrarianDTO getLibrarian(int ID) {
        Optional<Librarian> librarian = this.librarianRepo.findById(ID);
        return librarian.map(LibrarianDTO::toDto).orElse(null);
    }

    public void DeleteLibrarian(int ID) {
        this.librarianRepo.deleteById(ID);
    }

    public void saveLibrarian(LibrarianDTO librarianDTO) {
        if (librarianDTO.getEmployeeID() != null) {
            Librarian librarian = librarianRepo.findById(librarianDTO.getEmployeeID())
                    .orElseThrow(() -> new RuntimeException("Librarian not found."));
            librarian.setName(librarianDTO.getName());
            librarian.setAge(librarianDTO.getAge());
            librarian.setGender(librarianDTO.getGender());
        } else {
            throw new IllegalArgumentException("Can't update a librarian without an ID.");
        }
    }

    public void updateLibrarian(LibrarianDTO librarianDTO) {
        if (librarianDTO.getEmployeeID() != null) {
            Librarian librarian = librarianRepo.findById(librarianDTO.getEmployeeID())
                    .orElseThrow(() -> new RuntimeException("Librarian not found."));
            librarian.setName(librarianDTO.getName());
            librarian.setAge(librarianDTO.getAge());
            librarian.setGender(librarianDTO.getGender());
        } else {
            throw new IllegalArgumentException("Can't update a librarian without an ID.");
        }
    }


}
