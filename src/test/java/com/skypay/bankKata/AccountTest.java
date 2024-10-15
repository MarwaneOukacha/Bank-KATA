package com.skypay.bankKata;

import com.skypay.bankKata.service.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AccountTest {

    private Account account;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        account = new Account();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void deposit_shouldIncreaseBalance() {
        account.deposit(1000, "2012-01-10");
        account.printStatement();
        assertTrue(outputStream.toString().contains("1000"));
    }

    @Test
    void withdraw_shouldDecreaseBalance() {
        account.deposit(2000, "2012-01-13");
        account.withdraw(500, "2012-01-14");
        account.printStatement();
        assertTrue(outputStream.toString().contains("-500"));
    }

    @Test
    public void testPrintStatement() {
        Account account = new Account();
        account.deposit(1000, String.valueOf(LocalDate.of(2012, 1, 10)));
        account.deposit(2000, String.valueOf(LocalDate.of(2012, 1, 13)));
        account.withdraw(500, String.valueOf(LocalDate.of(2012, 1, 14)));

        // Capture console output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        account.printStatement();



        String expectedOutput = "DATE       | AMOUNT  | BALANCE\n"+
        "2012-01-10 | 1000   | 1000\n"+
        "2012-01-13 | 2000   | 3000\n"+
        "2012-01-14 | -500   | 2500\n";
        System.setOut(System.out);

        assertEquals(expectedOutput.trim(), outputStream.toString().trim());
    }

    @Test
    void multipleDepositsAndWithdrawals_shouldBeReflectedCorrectly() {
        account.deposit(1000, "2012-01-10");
        account.deposit(2000, "2012-01-13");
        account.withdraw(500, "2012-01-14");
        account.withdraw(200, "2012-01-15");

        account.printStatement();

        String expectedOutput = "DATE       | AMOUNT  | BALANCE\n"
                + "2012-01-10 | 1000   | 1000\n"
                + "2012-01-13 | 2000   | 3000\n"
                + "2012-01-14 | -500   | 2500\n"
                + "2012-01-15 | -200   | 2300\n";

        assertEquals(expectedOutput.trim(), outputStream.toString().trim());
    }
}
