package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Purchased;
import com.example.demo.service.PurchasedService;
import java.util.List;

@RestController
@RequestMapping("/api/purchaseds")
public class PurchasedController {
    @Autowired
    private PurchasedService purchasedService;

    @PostMapping
    public Purchased createPurchased(@RequestBody Purchased purchased) {
        return purchasedService.createPurchased(purchased);
    }

    @GetMapping
    public List<Purchased> getPurchaseds() {
        return purchasedService.getPurchaseds();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Purchased> updatePurchased(@PathVariable Long id, @RequestBody Purchased purchasedDetails) {
        Purchased updatedPurchased = purchasedService.updatePurchased(id, purchasedDetails);
        return ResponseEntity.ok(updatedPurchased);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchased(@PathVariable Long id) {
        purchasedService.deletePurchased(id);
        return ResponseEntity.noContent().build();
    }
}