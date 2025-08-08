package com.example.petshop.service;

import com.example.petshop.config.SecurityConfig;
import com.example.petshop.model.AppUser;
import com.example.petshop.model.Product;
import com.example.petshop.repository.AppUserRepository;
import com.example.petshop.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostConstruct
    public void init() {
        // Создаём тестовые аккаунты, если их нет
        if (appUserRepository.count() == 0) {
            AppUser user = new AppUser("user", passwordEncoder.encode("1234"), "USER", 100_000);
            AppUser admin = new AppUser("admin", passwordEncoder.encode("admin"), "ADMIN", 500_000);
            appUserRepository.saveAll(List.of(user, admin));
        }

        // Создаём тестовые товары, если их нет
        if (productRepository.count() == 0) {
            productRepository.saveAll(List.of(
                    new Product("iPhone13", 285_000),
                    new Product("MacBook", 500_000),
                    new Product("Airpods", 72_000)
            ));
        }
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public AppUser getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated() || auth instanceof AnonymousAuthenticationToken) {
            return null;
        }
        String username = auth.getName();
        return appUserRepository.findByUsername(username).orElse(null);
    }

    public String buyProductById(long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return "Продукт не найден";
        }
        AppUser user = getCurrentUser();
        if (user.getBalance() >= product.getPrice()) {
            user.setBalance(user.getBalance() - product.getPrice());
            appUserRepository.save(user);
            return "Покупка успешна!";
        } else {
            return "Недостаточно средств!";
        }
    }

    public void topUp(int amount) {
        AppUser user = getCurrentUser();
        user.setBalance(user.getBalance() + amount);
        appUserRepository.save(user);
    }

    public void addProduct(String name, int price) {
        productRepository.save(new Product(name, price));
    }
}

