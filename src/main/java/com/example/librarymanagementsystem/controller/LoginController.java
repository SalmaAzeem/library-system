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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("loggedInUserID")
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
                model.addAttribute("loggedInUserID", librarianDTO.getEmployeeID());
                return "redirect:/"; // Redirect to home page
            } else {
                model.addAttribute("error", "Invalid Employee ID");
                return "Login";
            }
        } else if ("user".equalsIgnoreCase(role)) {
            UserDTO user = userService.getUser(userID);
            if (user != null) {
                model.addAttribute("loggedInUserID", user.getID());
                return "redirect:/"; // Redirect to home page
            } else {
                model.addAttribute("error", "Invalid User ID");
                return "Login";
            }
        }
        model.addAttribute("error", "Please select a role.");
        return "Login";
    }


    @GetMapping("/logout")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete(); // Clear the session attributes
        return "redirect:/login";
    }

    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "SignUp";
    }

    @PostMapping("/signup")
    public String processSignUp(UserDTO userDTO, Model model) {
        try {
            userService.saveUser(userDTO);
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("error", "Unable to Sign up. Please try again.");
            return "SignUp";
        }
    }
}
