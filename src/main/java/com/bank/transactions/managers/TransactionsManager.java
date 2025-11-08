package com.bank.transactions.managers;

import com.bank.transactions.Transaction;
import com.bank.transactions.TransactionTypes;
import com.google.inject.Singleton;

import java.util.*;

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

        Calendar searchCal = Calendar.getInstance();
        searchCal.setTime(date);
        int searchYear = searchCal.get(Calendar.YEAR);
        int searchMonth = searchCal.get(Calendar.MONTH);
        int searchDay = searchCal.get(Calendar.DAY_OF_MONTH);

        ArrayList<Transaction> result = new ArrayList<>();
        Calendar transCal = Calendar.getInstance();

        for (Transaction transaction : transactions) {
            transCal.setTime(transaction.getTimestamp());
            int transYear = transCal.get(Calendar.YEAR);
            int transMonth = transCal.get(Calendar.MONTH);
            int transDay = transCal.get(Calendar.DAY_OF_MONTH);

            if (transYear == searchYear && transMonth == searchMonth && transDay == searchDay) {
                result.add(transaction);
            }
        }
        return result;
    }

//    public static void main(String[] args) {
//        TransactionsManager transactionsManager = new TransactionsManager();
//        transactionsManager.addTransaction(new Transaction("uuid123", "uuid100", TransactionTypes.DEPOSIT, 100.0, new Date()));
//        System.out.println(Arrays.toString(transactionsManager.findTransactionsByDate(new Date()).toArray()));
//    }
}
