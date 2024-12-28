package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.model.dto.LibraryDTO;
import com.example.librarymanagementsystem.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.List;

/**
 * Controller class for managing the library.
 */
@Controller
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @GetMapping("/libinfo")
    public String displayInfo(Model model) {
        List<LibraryDTO> libraryDTOS = libraryService.getAllLibraries();
        model.addAttribute("libraryDTOS", libraryDTOS);
        return "Library";
    }
}
