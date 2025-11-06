package com.bank.transactions.services;

import com.bank.bankAccounts.BaseBankAccount;
import com.bank.bankAccounts.managers.BankAccountsManager;
import com.bank.transactions.Transaction;
import com.bank.transactions.TransactionTypes;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class TransactionLogMessageCreator {

    @Inject
    BankAccountsManager bankAccountsManager;

    public String createMessage(Transaction transaction, String paymentCardNumber) {
        BaseBankAccount bankAccount = bankAccountsManager.findBankAccountByUuid(transaction.getAccountUuid());
        TransactionTypes type = transaction.getTransactionType();
        double amount = transaction.getAmount();

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

    public String createMessage(Transaction transaction) {
        return createMessage(transaction, null);
    }
}

