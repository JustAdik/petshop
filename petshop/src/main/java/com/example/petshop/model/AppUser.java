package com.example.petshop.model;

import jakarta.persistence.*;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int balance;
    private String username;
    private String password;
    private String role;

    public AppUser() {
    }

    public AppUser(String username, String password, String role, int balance) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.balance = balance;
    }


    public String buy(Product product) {
        if (this.balance >= product.getPrice()) {
            this.balance -= product.getPrice();
            return "Покупка прошла успешно: " + product.getName();
        } else {
            return "Недостаточно средств для покупки " + product.getName();
        }
    }
    public void addBalance(int amount) {
        this.balance += amount;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}

