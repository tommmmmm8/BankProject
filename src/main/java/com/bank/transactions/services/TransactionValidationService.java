package com.bank.transactions.services;

import com.bank.bankAccounts.BaseBankAccount;

public class TransactionValidationService {

    public void validateDepositTransaction(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Deposit/Withdrawal amount must be positive.");]

        amlCheck(amount);
    }

    public void validateWithdrawalTransaction(BaseBankAccount account, double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Deposit/Withdrawal amount must be positive.");

        if (amount > account.getBalance())
            throw new IllegalArgumentException("Withdrawal amount must not be greater than account's balance.");
    }

    public void amlCheck(double amount) {
        if (amount > 10000)
            throw new IllegalArgumentException("Transaction flagged for AML review.");
    }

}
