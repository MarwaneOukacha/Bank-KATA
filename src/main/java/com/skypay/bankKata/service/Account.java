package com.skypay.bankKata.service;


import com.skypay.bankKata.entites.Transaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Account implements AccountService{
    private List<Transaction> transactions;

    public Account() {
        this.transactions = new ArrayList<>();
    }
    @Override
    public void deposit(int amount, String date) {
        transactions.add(new Transaction(LocalDate.parse(date), amount));
    }
    @Override
    public void withdraw(int amount, String date) {
        transactions.add(new Transaction(LocalDate.parse(date), -amount));
    }
    @Override
    public void printStatement() {
        System.out.println("DATE       | AMOUNT  | BALANCE");
        int balance = 0;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (Transaction transaction : transactions) {
            balance += transaction.getAmount();
            System.out.printf("%s | %d   | %d%n",
                    transaction.getDate().format(formatter),
                    transaction.getAmount(),
                    balance);
        }
    }





    public static void main(String[] args) {
        Account account = new Account();
        account.deposit(1000, "2012-01-10");
        account.deposit(2000, "2012-01-13");
        account.withdraw(500, "2012-01-14");
        account.printStatement();
    }
}