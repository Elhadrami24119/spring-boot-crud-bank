package com.sjprogramming.bankapp.service;

import java.util.List;
import com.sjprogramming.bankapp.entity.Account;

public interface AccountService {
    public Account createAccount(Account account);
    public Account getAccountDetailsByAccountNumber(long accountNumber);
    public List<Account> getAllAccountDetails();
    public Account depositAmount(long accountNumber, double amount);
    public Account withdrwaAmount(long accountNumber, double amount);
    public void closeAccount(long accountNumber);
}