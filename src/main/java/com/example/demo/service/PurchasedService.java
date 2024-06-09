package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Purchased;
import com.example.demo.repository.PurchasedRepository;
import java.util.List;

@Service
public class PurchasedService {
    @Autowired
    private PurchasedRepository purchasedRepository;

    public Purchased createPurchased(Purchased purchased) {
        return purchasedRepository.save(purchased);
    }

    public List<Purchased> getPurchaseds() {
        return purchasedRepository.findAll();
    }

    public Purchased updatePurchased(Long id, Purchased purchasedDetails) {
        Purchased purchased = purchasedRepository.findById(id).orElseThrow();
        purchased.setPurchasedDate(purchasedDetails.getPurchasedDate());
        purchased.setValue(purchasedDetails.getValue());
        purchased.setBook(purchasedDetails.getBook());
        return purchasedRepository.save(purchased);
    }

    public void deletePurchased(Long id) {
        purchasedRepository.deleteById(id);
    }
}