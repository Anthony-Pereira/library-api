package com.digitalcreative.loan.controller;

import com.digitalcreative.loan.model.Loan;
import com.digitalcreative.loan.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class LoanController {

    @Autowired
    LoanService loanService;

    /**
     * Create - Add a new loan
     * @param loan An object loan
     * @return The loan
     * object saved
     */
    @PostMapping("/loan")
    public Loan createLoan(@RequestBody Loan loan) {
        return loanService.saveLoan(loan);
    }


    /**
     * Read - Get one loan
     * @param id The id of the loan
     * @return A loan object full filled
     */
    @GetMapping("/loan/{id}")
    public Loan getLoan(@PathVariable("id") final Long id) {
        Optional<Loan> loan = loanService.getLoan(id);
        if(loan.isPresent()) {
            return loan.get();
        } else {
            return null;
        }
    }

    /**
     * Read - Get all loans
     * @return - An Iterable object of loan full filled
     */
    @GetMapping("/loans")
    public Iterable<Loan> getLoans() {
        return loanService.getLoan();
    }

    /**
     * Update - Update an existing loan
     * @param id - The id of the loan to update
     * @param loan - The loan object updated
     * @return
     */
    @PutMapping("/loan/{id}")
    public Loan updateLoan(@PathVariable("id") final Long id, @RequestBody Loan loan) {
        Optional<Loan> e = loanService.getLoan(id);
        if(e.isPresent()) {
            Loan currentLoan = e.get();

            String borrowingDate = loan.getBorrowingDate();
            if(borrowingDate != null) {
                currentLoan.setBorrowingDate(borrowingDate);
            }
            String returnDate = loan.getReturnDate();
            if(returnDate != null) {
                currentLoan.setReturnDate(returnDate);;
            }
            Boolean prolongation = loan.getProlongation();
            if(prolongation != null) {
                currentLoan.setProlongation(prolongation);
            }
            Integer userId = loan.getUserId();
            if(userId != null) {
                currentLoan.setUserId(userId);;
            }
            Integer bookId = loan.getBookId();
            if(bookId != null) {
                currentLoan.setBookId(bookId);;
            }
            loanService.saveLoan(currentLoan);
            return currentLoan;
        } else {
            return null;
        }
    }


    /**
     * Delete - Delete a loan
     * @param id - The id of the loan to delete
     */
    @DeleteMapping("/loan/{id}")
    public void deleteLoan(@PathVariable("id") final Long id) {
        loanService.deleteLoan(id);
    }

}
