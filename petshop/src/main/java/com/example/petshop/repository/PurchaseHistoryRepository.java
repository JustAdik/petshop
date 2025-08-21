package com.example.petshop.repository;

import com.example.petshop.model.AppUser;
import com.example.petshop.model.PurchaseHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseHistoryRepository extends JpaRepository<PurchaseHistory, Long> {
    List<PurchaseHistory> findByUserOrderByPurchaseDateDesc(AppUser user);
}
