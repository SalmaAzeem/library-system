package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.model.dto.LibrarianDTO;
import com.example.librarymanagementsystem.model.dto.UserDTO;
import com.example.librarymanagementsystem.service.LibrarianService;
import com.example.librarymanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private LibrarianService librarianService;

    @GetMapping("/login")
    public String displayForm(Model model) {
        model.addAttribute("role", "");
        return "Login";
    }

    @PostMapping("/login")
    public String handleLogin(String role, Integer employeeID, Integer userID, Model model) {
        if ("librarian".equalsIgnoreCase(role)) {
            LibrarianDTO librarianDTO = librarianService.getLibrarian(employeeID);
            if (librarianDTO != null) {
                return "redirect:/";
            } else {
                model.addAttribute("error", "Invalid Employee ID");
                return "Login";
            }
        } else if ("user".equalsIgnoreCase(role)) {
            UserDTO user = userService.getUser(userID);
            if (user != null) {
                return "redirect:/";
            } else {
                model.addAttribute("error", "Invalid User ID");
                return "Login";
            }
        }
        model.addAttribute("error", "Please select a role.");
        return "Login";
    }

    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "SignUp";
    }

    @PostMapping("/signup")
    public String processSignUp(UserDTO userDTO, Model model) {
        try {
            System.out.println(userDTO.getID());
            System.out.println(userDTO.getName());
            System.out.println(userDTO.getAge());
            System.out.println(userDTO.getGender());
            userService.saveUser(userDTO);
            return "redirect:/";
        } catch (Exception e) {
            model.addAttribute("error", "Unable to Sign up. Please try again.");
            return "SignUp";
        }
    }

}
