package com.bank.transactions.services;

import com.bank.bankAccounts.BaseBankAccount;
import com.google.inject.Singleton;

@Singleton
public class TransactionLogMessageCreator {

    public String createMessage(TransactionTypes type, BaseBankAccount bankAccount, double amount, String paymentCardNumber) {
        double newBalance = bankAccount.getBalance();
        double previousBalance = type == TransactionTypes.DEPOSIT ? newBalance - amount : newBalance + amount;

        if (type == TransactionTypes.DEPOSIT) {
            return "Deposited " + amount + " to account: " + bankAccount.getAccountNumber() +
                               ". { " + previousBalance + " -> " + newBalance + " }";
        } else if (type == TransactionTypes.WITHDRAWAL) {
            return "Withdrew " + amount + " from account: " + bankAccount.getAccountNumber() +
                               (paymentCardNumber != null ? " (Card: " + paymentCardNumber + ")" : "") +
                                ". { " + previousBalance + " -> " + newBalance + " }";
        } else
            throw new IllegalArgumentException("Invalid transaction type: " + type);
    }

    public String createMessage(TransactionTypes type, BaseBankAccount bankAccount, double amount) {
        return createMessage(type, bankAccount, amount, null);
    }
}

