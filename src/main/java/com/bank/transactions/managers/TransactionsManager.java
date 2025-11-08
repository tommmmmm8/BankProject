package com.bank.transactions.managers;

import com.bank.transactions.Transaction;
import com.bank.transactions.TransactionTypes;
import com.google.inject.Singleton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

@Singleton
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

    public ArrayList<Transaction> findTransactionsByDate(Date date) {
        if (date == null) throw new IllegalArgumentException("Date cannot be null");
        ArrayList<Transaction> result = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getTimestamp().equals(date))
                result.add(transaction);
        }
        return result;
    }

//    public static void main(String[] args) {
//        TransactionsManager transactionsManager = new TransactionsManager();
//        transactionsManager.addTransaction(new Transaction("uuid123", "uuid100", TransactionTypes.DEPOSIT, 100.0, new Date()));
//        System.out.println(Arrays.toString(transactionsManager.findTransactionsByDate(new Date()).toArray()));
//    }
}
