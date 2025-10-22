package com.bank.transactions.services;

import com.bank.bankAccounts.BaseBankAccount;
import com.bank.cards.PaymentCard;

public class TransactionLogger {

    public void logTransaction(TransactionTypes type, BaseBankAccount bankAccount, double amount, PaymentCard paymentCard) {
        double newBalance = bankAccount.getBalance();
        double previousBalance = type == TransactionTypes.DEPOSIT ? newBalance - amount : newBalance + amount;

        if (type == TransactionTypes.DEPOSIT) {
            System.out.println("Deposit of " + amount + " made to account: " + bankAccount.getAccountNumber() +
                               ". Previous balance: " + previousBalance + ", New balance: " + newBalance);
        } else if (type == TransactionTypes.WITHDRAWAL) {
            System.out.println("Withdrawal of " + amount + " made from account: " + bankAccount.getAccountNumber() +
                               (paymentCard != null ? " using a payment card (" + paymentCard.getCardNumber() + ")" : ".") +
                               " Previous balance: " + previousBalance + ", New balance: " + newBalance);
        }
    }

    public void logTransaction (TransactionTypes type, BaseBankAccount bankAccount, double amount) {
        logTransaction(type, bankAccount, amount, null);
    }


}

