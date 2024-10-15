package com.skypay.bankKata.entites;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;


@Data
public class Transaction {
    private LocalDate date;
    private int amount;

    public Transaction(LocalDate date, int amount) {
        this.date = date;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }
}