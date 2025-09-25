package com.bank.bankAccounts.services;

import com.bank.bankAccounts.BaseBankAccount;

public class BankAccountService {

    public void deposit(BaseBankAccount account, double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Deposit amount muse be positive.");
        double newBalance = account.getBalance() + amount;
        account.setBalance(newBalance);
    }

    public void withdraw(BaseBankAccount account, double amount) {
        if (amount < 0)
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        if (account.getBalance() >= amount) {
            double newBalance = account.getBalance() - amount;
            account.setBalance(newBalance);
        }
        else
            throw new IllegalArgumentException("Withdrawal amount must not be greater than account's balance.");
    }

}
