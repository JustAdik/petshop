package com.example.petshop.service;

import com.example.petshop.model.AppUser;
import com.example.petshop.repository.AppUserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserService {
    private final AppUserRepository appUserRepository;

    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public AppUser getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return appUserRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Такого пользователя нету: " + username));
    }

    public void saveUser(AppUser user) {
        appUserRepository.save(user);
    }
}
