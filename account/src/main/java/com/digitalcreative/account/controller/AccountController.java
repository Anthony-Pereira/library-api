package com.digitalcreative.account.controller;

import com.digitalcreative.account.model.Account;
import com.digitalcreative.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    /**
     * Create - Add a new account
     * @param account An object account
     * @return The account object saved
     */
    @PostMapping("/account")
    public Account createAccount(@RequestBody Account account) {
        return accountService.saveAccount(account);
    }

    /**
     * Read - Get one account
     * @param id The id of the account
     * @return An account object full filled
     */
    @GetMapping("/account/{id}")
    public Account getAccount(@PathVariable("id") final Long id) {
        Optional<Account> account = accountService.getAccount(id);
        if(account.isPresent()) {
            return account.get();
        } else {
            return null;
        }
    }

    /**
     * Read - Get all accounts
     * @return - An Iterable object of account full filled
     */
    @GetMapping("/accounts")
    public Iterable<Account> getAccounts() {
        return accountService.getAccounts();
    }

    /**
     * Update - Update an existing account
     * @param id - The id of the account to update
     * @param account - The account object updated
     * @return
     */
    @PutMapping("/account/{id}")
    public Account updateAccount(@PathVariable("id") final Long id, @RequestBody Account account) {
        Optional<Account> e = accountService.getAccount(id);
        if(e.isPresent()) {
            Account currentAccount = e.get();

            String name = account.getName();
            if(name != null) {
                currentAccount.setName(name);
            }
            String surname = account.getSurname();
            if(surname != null) {
                currentAccount.setSurname(surname);;
            }
            String email = account.getEmail();
            if(email != null) {
                currentAccount.setEmail(email);
            }
            String password = account.getPassword();
            if(password != null) {
                currentAccount.setPassword(password);;
            }
            String phone = account.getPhone();
            if(phone != null) {
                currentAccount.setPhone(phone);;
            }
            accountService.saveAccount(currentAccount);
            return currentAccount;
        } else {
            return null;
        }
    }

    /**
     * Delete - Delete an account
     * @param id - The id of the account to delete
     */
    @DeleteMapping("/account/{id}")
    public void deleteAccount(@PathVariable("id") final Long id) {
        accountService.deleteAccount(id);
    }


}
