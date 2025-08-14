package com.example.petshop.controller;

import com.example.petshop.model.AppUser;
import com.example.petshop.repository.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    private final AppUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(AppUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new AppUser());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute AppUser user, Model model) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            model.addAttribute("error", "Пользователь уже существует");
            return "register";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setBalance(0);
        user.setRole("USER");
        userRepository.save(user);
        return "redirect:/login";
    }
}