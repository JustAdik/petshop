package com.example.petshop.controller;

import com.example.petshop.model.AppUser;
import com.example.petshop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ShopController {

    @Autowired
    private ShopService shopService;

    // магаз
    @GetMapping("/shop")
    public String shop(Model model) {
        model.addAttribute("products", shopService.getProducts());
        model.addAttribute("user", shopService.getCurrentUser());
        return "shop";
    }

    @GetMapping("/")
    public String index(Model model) {
        AppUser currentUser = shopService.getCurrentUser(); // или твой метод
        model.addAttribute("user", currentUser);
        model.addAttribute("products", shopService.getProducts());
        return "index";
    }

    // покупка
    @PostMapping("/buy")
    public String buy(@RequestParam int id, Model model) {
        String message = shopService.buyProductById(id);
        model.addAttribute("message", message);
        model.addAttribute("products", shopService.getProducts());
        model.addAttribute("user", shopService.getCurrentUser());
        return "shop";
    }

    // пополнение баланса
    @PostMapping("/topup")
    public String topUp(@RequestParam int amount, Model model) {
        shopService.topUp(amount);
        model.addAttribute("message", "Баланс пополнен на " + amount + " ₸");
        model.addAttribute("products", shopService.getProducts());
        model.addAttribute("user", shopService.getCurrentUser());
        return "shop";
    }

    // новый товар
    @PostMapping("/add")
    public String addProduct(@RequestParam String name, @RequestParam int price, Model model) {
        shopService.addProduct(name, price);
        model.addAttribute("message", "Товар добавлен!");
        model.addAttribute("products", shopService.getProducts());
        model.addAttribute("user", shopService.getCurrentUser());
        return "shop";
    }
}





