package com.example.petshop.repository;

import com.example.petshop.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepository extends JpaRepository<AppUser, Integer> {}
