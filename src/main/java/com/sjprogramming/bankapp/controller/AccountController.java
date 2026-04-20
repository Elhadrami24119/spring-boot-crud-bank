package com.sjprogramming.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sjprogramming.bankapp.entity.Account;
import com.sjprogramming.bankapp.service.AccountService;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // إنشاء حساب جديد
    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account createdAccount = accountService.createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAccount);
    }

    // جلب تفاصيل حساب برقم الحساب
    @GetMapping("/{accountNumber}")
    public ResponseEntity<Account> getAccountByAccountNumber(@PathVariable Long accountNumber) {
        // تم تصحيح المسمى من service إلى accountService
        Account account = accountService.getAccountDetailsByAccountNumber(accountNumber);
        return ResponseEntity.ok(account);
    }

    // جلب كل الحسابات
    @GetMapping("/all")
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccountDetails();
        return ResponseEntity.ok(accounts);
    }

    // دالة الإيداع (Deposit)
    @PutMapping("/deposit/{accountNumber}/{amount}")
    public Account depositAccount(@PathVariable Long accountNumber, @PathVariable Double amount) {
        Account account = accountService.depositAmount(accountNumber, amount);
        return account;
    }

    // دالة السحب (Withdraw)
    @PutMapping("/withdraw/{accountNumber}/{amount}")
    public Account witAccount(@PathVariable Long accountNumber, @PathVariable Double amount) {
        Account account = accountService.withdrwaAmount(accountNumber, amount);
        return account;
    }

    // دالة حذف الحساب
    @DeleteMapping("/delete/{accountNumber}")
    public ResponseEntity<String> closeAccount(@PathVariable Long accountNumber) {
        accountService.closeAccount(accountNumber);
        return ResponseEntity.ok("Account closed successfully");
    }
}