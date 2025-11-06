package com.bank.transactions.managers;

import com.bank.transactions.Transaction;

import java.util.ArrayList;
import java.util.Objects;

public class TransactionsManager {

    private static ArrayList<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction transaction) {
        if (transaction == null) throw new IllegalArgumentException("Transaction cannot be null");
        transactions.add(transaction);
    }

    public void removeTransaction(String transactionUuid) {
        if (transactionUuid.isEmpty()) throw new IllegalArgumentException("Uuid cannot be null");
        transactions.removeIf( transaction -> Objects.equals(transaction.getUuid(), transactionUuid));
    }
}
