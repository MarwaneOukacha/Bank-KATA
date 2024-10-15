package com.skypay.bankKata.web;


import com.skypay.bankKata.entites.Transaction;
import com.skypay.bankKata.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/deposit")
    public void deposit(@RequestParam int amount, @RequestParam String date) {
        accountService.deposit(amount, date);
    }

    @PostMapping("/withdraw")
    public void withdraw(@RequestParam int amount, @RequestParam String date) {
        accountService.withdraw(amount, date);
    }

    @GetMapping("/statement")
    public void printStatement() {
        accountService.printStatement();
    }
}
