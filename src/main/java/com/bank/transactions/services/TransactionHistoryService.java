package com.bank.transactions.services;

import com.bank.serialization.TransactionJsonSerializationService;
import com.bank.transactions.Transaction;
import com.bank.transactions.TransactionTypes;
import com.bank.transactions.managers.TransactionsManager;
import com.google.gson.Gson;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

@Singleton
public class TransactionHistoryService {

    @Inject
    private TransactionsManager transactionsManager;

    @Inject
    private TransactionJsonSerializationService transactionJsonSerializationService;

    @Inject
    private Gson gson;

    public void processAndSaveTransactionHistory() {
        // get transactions
        // filter transaction to get relevant ones to save
        ArrayList<Transaction> transactions = transactionsManager.findTransactionsByDate(new Date());

        // group transactions by account
        Map<String, ArrayList<Transaction>> transactionsByAccount = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getAccountUuid, Collectors.toCollection(ArrayList::new)));

        transactionsByAccount.forEach((accountUuid, accountTransactions) -> {
            if (accountTransactions.isEmpty()) {
                System.out.println("No transactions found for account: " + accountUuid);
                return;
            }

            // serializing the data
            // saving to a file
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dateSuffix = dateFormat.format(new Date());
            String filePath = "C:\\Tom\\01_programovani\\25-26\\Java - Delta\\Bank\\data\\";
            String fileName = accountUuid + "-TransactionHistory-" + dateSuffix + ".json";
            new File(filePath).mkdir(); // Ensure the directory exists

            try (FileWriter writer = new FileWriter(filePath + fileName)) {
                gson.toJson(accountTransactions, writer);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
