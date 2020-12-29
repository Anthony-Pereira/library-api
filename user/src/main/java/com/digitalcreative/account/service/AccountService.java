package com.digitalcreative.account.service;

import com.digitalcreative.account.model.Account;
import com.digitalcreative.account.repository.AccountRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Optional<Account> getAccount(final Long id) {
        return accountRepository.findById(id);
    }

    public Iterable<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public void deleteAccount(final Long id) {
        accountRepository.deleteById(id);
    }

    public Account saveAccount(Account account) {
        Account savedAccount = accountRepository.save(account);
        return savedAccount;
    }

}
