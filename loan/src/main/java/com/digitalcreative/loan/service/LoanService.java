package com.digitalcreative.loan.service;

import com.digitalcreative.loan.model.Loan;
import com.digitalcreative.loan.repository.LoanRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    public Optional<Loan> getLoan(final Long id) {
        return loanRepository.findById(id);
    }

    public Iterable<Loan> getLoan() {
        return loanRepository.findAll();
    }

    public void deleteLoan(final Long id) {
        loanRepository.deleteById(id);
    }

    public Loan saveLoan(Loan loan) {
        Loan savedLoan = loanRepository.save(loan);
        return savedLoan;
    }

}
