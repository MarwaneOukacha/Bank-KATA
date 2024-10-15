package com.skypay.bankKata.service;

import com.skypay.bankKata.entites.Transaction;

import java.util.List;

public interface AccountService {
    public void deposit(int amount, String date);
    public void withdraw(int amount, String date);
    public void printStatement();
}
