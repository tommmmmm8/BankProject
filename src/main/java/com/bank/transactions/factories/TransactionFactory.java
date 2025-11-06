package com.bank.transactions.factories;

import com.bank.transactions.Transaction;
import com.bank.transactions.TransactionTypes;
import com.bank.transactions.generators.TransactionUuidGenerator;
import com.bank.transactions.managers.TransactionsManager;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.Date;

@Singleton
public class TransactionFactory {

    @Inject
    private TransactionUuidGenerator transactionUuidGenerator;

    @Inject
    private TransactionsManager transactionsManager;

    public Transaction createTransaction(String accountUuid, TransactionTypes transactionType, double amount, Date timestamp) {
        String transactionUuid = transactionUuidGenerator.generateUuid();
        Transaction transaction = new Transaction(transactionUuid, accountUuid, transactionType, amount, timestamp);

        transactionsManager.addTransaction(transaction);
        return transaction;
    }
}
