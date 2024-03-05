package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class BankAccountTest {
    
    private BankAccount account;

    @Test
    public void createBankAccountPositiveStartingBalance() {
        int startingBalance = 100;
        account = new BankAccount(startingBalance);

        int expected = 100;
        int actual = account.getBalance();

        assertEquals(expected, actual);
    }

    @Test
    public void createBankAccountZeroStartingBalance() {
        int startingBalance = 0;
        account = new BankAccount(startingBalance);
        int expected = 0;

        int actual = account.getBalance();

        assertEquals(expected, actual);
    }


    @Test
    public void lessAmmountThanBalanceWithdraw(){
        int startingBalance = 100;
        account = new BankAccount(startingBalance);
        int amount = 50;
        boolean expected = true;

        boolean actual = account.withdraw(amount);

        assertEquals(expected, actual);
    }

    @Test
    public void equalAmmountThanBalanceWithdraw(){
        int startingBalance = 100;
        account = new BankAccount(startingBalance);
        int amount = 100;
        boolean expected = true;

        boolean actual = account.withdraw(amount);

        assertEquals(expected, actual);
    }

    @Test 
    public void greaterAmmountThanBalanceWithdraw(){
        int startingBalance = 100;
        account = new BankAccount(startingBalance);
        int amount = 150;
        boolean expected = false;

        boolean actual = account.withdraw(amount);

        assertEquals(expected, actual);
    }

    @Test
    public void positiveDeposit(){
        int startingBalance = 100;
        account = new BankAccount(startingBalance);
        int amount = 50;
        int expected = 150;

        int actual = account.deposit(amount);

        assertEquals(expected, actual);
    }

    @Test
    public void negativeDeposit(){
        int startingBalance = 100;
        account = new BankAccount(startingBalance);
        int amount = -50;

        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(amount);
        });
    }

    @Test
    public void zeroDeposit(){
        int startingBalance = 100;
        account = new BankAccount(startingBalance);
        int amount = 0;
        int expected = 100;

        int actual = account.deposit(amount);

        assertEquals(expected, actual);
    }

    @Test
    public void paymentTest(){
        int total_amount = 1000;
        double interest = 0.1;
        int npayments = 12;
        double expected = 87.915;
        double delta = 0.001;

        double actual = account.payment(total_amount, interest, npayments);

        assertEquals(expected, actual, delta);
    }



}
