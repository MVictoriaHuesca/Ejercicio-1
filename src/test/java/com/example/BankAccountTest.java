package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class BankAccountTest {
    
    private BankAccount account;

    @Test
    public void createBankAccountPositiveStartingBalanceTest() {
        int startingBalance = 100;
        account = new BankAccount(startingBalance);

        int expected = 100;
        int actual = account.getBalance();

        assertEquals(expected, actual);
    }

    @Test
    public void createBankAccountZeroStartingBalanceTest() {
        int startingBalance = 0;
        account = new BankAccount(startingBalance);
        int expected = 0;

        int actual = account.getBalance();

        assertEquals(expected, actual);
    }


    @Test
    public void lessAmmountThanBalanceWithdrawTest(){
        int startingBalance = 100;
        account = new BankAccount(startingBalance);
        int amount = 50;
        boolean expected = true;

        boolean actual = account.withdraw(amount);

        assertEquals(expected, actual);
    }

    @Test
    public void equalAmmountAndBalanceWithdrawTest(){
        int startingBalance = 100;
        account = new BankAccount(startingBalance);
        int amount = 100;
        boolean expected = true;

        boolean actual = account.withdraw(amount);

        assertEquals(expected, actual);
    }

    @Test 
    public void greaterAmmountThanBalanceWithdrawTest(){
        int startingBalance = 100;
        account = new BankAccount(startingBalance);
        int amount = 150;
        boolean expected = false;

        boolean actual = account.withdraw(amount);

        assertEquals(expected, actual);
    }

    @Test
    public void positiveDepositTest(){
        int startingBalance = 100;
        account = new BankAccount(startingBalance);
        int amount = 50;
        int expected = 150;

        int actual = account.deposit(amount);

        assertEquals(expected, actual);
    }

    @Test
    public void negativeDepositTest(){
        int startingBalance = 100;
        account = new BankAccount(startingBalance);
        int amount = -50;

        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(amount);
        });
    }

    @Test
    public void zeroDepositTest(){
        int startingBalance = 100;
        account = new BankAccount(startingBalance);
        int amount = 0;
        int expected = 100;

        int actual = account.deposit(amount);

        assertEquals(expected, actual);
    }

    @Test
    public void paymentTest() {
        int startingBalance = 100;
        account = new BankAccount(startingBalance);
        double totalAmount = 1000.0;
        double interest = 0.05;
        int nPayments = 12;
        double expected = 112.82;

        double actual = account.payment(totalAmount, interest, nPayments);

        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void pendingZeroMonthTest() {
        int startingBalance = 100;
        account = new BankAccount(startingBalance);
        double amount = 1000.0;
        double interest = 0.05;
        int nPayments = 12;
        int month = 0;
        double expected = 1000.0;

        double actual = account.pending(amount, interest, nPayments, month);

        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void pendingFirstMonthTest() {
        int startingBalance = 100;
        account = new BankAccount(startingBalance);
        double amount = 1000.0;
        double interest = 0.05;
        int nPayments = 12;
        int month = 1;
        double expected = 937.17;

        double actual = account.pending(amount, interest, nPayments, month);

        assertEquals(expected, actual, 0.01);
    }
}

