package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Borrower;
import com.example.demo.repository.BorrowerRepository;

import java.util.List;

@Service
public class BorrowerService {
    @Autowired
    private BorrowerRepository borrowerRepository;

    public Borrower createBorrower(Borrower borrower) {
        return borrowerRepository.save(borrower);
    }

    public List<Borrower> getBorrowers() {
        return borrowerRepository.findAll();
    }

    public Borrower updateBorrower(Long id, Borrower borrowerDetails) {
        Borrower borrower = borrowerRepository.findById(id).orElseThrow();
        borrower.setName(borrowerDetails.getName());
        borrower.setEmail(borrowerDetails.getEmail());
        return borrowerRepository.save(borrower);
    }

    public void deleteBorrower(Long id) {
        borrowerRepository.deleteById(id);
    }
}