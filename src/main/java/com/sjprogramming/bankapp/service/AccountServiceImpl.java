package com.sjprogramming.bankapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjprogramming.bankapp.entity.Account;
import com.sjprogramming.bankapp.repo.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository repo;

    @Override
    public Account createAccount(Account account) {
        return repo.save(account);
    }

    @Override
    public Account getAccountDetailsByAccountNumber(long accountNumber) {
        // البحث عن الحساب أو إرجاع خطأ إذا لم يوجد
        Optional<Account> account = repo.findById(accountNumber);
        if(account.isEmpty()) {
            throw new RuntimeException("Account is not present");
        }
        Account account_found = account.get();
        return account_found;
    }

    @Override
    public List<Account> getAllAccountDetails() {
        List<Account> listOfAccounts = repo.findAll();
        return listOfAccounts;
    }

    @Override
    public Account depositAmount(long accountNumber, double amount) {
        Optional<Account> account = repo.findById(accountNumber);
        if(account.isEmpty()) {
            throw new RuntimeException("Account is not present");
        }
        Account accountPresent = account.get();
        double totalBalance = accountPresent.getAccount_balance() + amount;
        accountPresent.setAccount_balance(totalBalance);
        repo.save(accountPresent);
        return accountPresent;
    }

@Override
    public Account withdrwaAmount(long accountNumber, double amount) {
        Optional<Account> account = repo.findById(accountNumber);
        
        if(account.isEmpty()) {
            throw new RuntimeException("Account is not present");
        }
        
        Account accountPresent = account.get();
        
        if (accountPresent.getAccount_balance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }
        
        double accountBalance = accountPresent.getAccount_balance() - amount;
        accountPresent.setAccount_balance(accountBalance);
        repo.save(accountPresent);
        
        return accountPresent;
    }

    @Override
    public void closeAccount(long accountNumber) {
        Account account = getAccountDetailsByAccountNumber(accountNumber);
        repo.delete(account);
    }
}