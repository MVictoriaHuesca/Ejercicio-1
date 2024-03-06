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



}
