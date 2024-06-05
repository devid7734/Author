package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Loan;
import com.example.demo.repository.LoanRepository;

import java.util.List;

@Service
public class LoanService {
    @Autowired
    private LoanRepository loanRepository;

    public Loan createLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    public List<Loan> getLoans() {
        return loanRepository.findAll();
    }

    public Loan updateLoan(Long id, Loan loanDetails) {
        Loan loan = loanRepository.findById(id).orElseThrow();
        loan.setLoanDate(loanDetails.getLoanDate());
        loan.setReturnDate(loanDetails.getReturnDate());
        loan.setBook(loanDetails.getBook());
        loan.setBorrower(loanDetails.getBorrower());
        return loanRepository.save(loan);
    }

    public void deleteLoan(Long id) {
        loanRepository.deleteById(id);
    }
}
