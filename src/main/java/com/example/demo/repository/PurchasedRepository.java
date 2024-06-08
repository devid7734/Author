package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Purchased;

public interface PurchasedRepository extends JpaRepository<Purchased, Long> {
    
}