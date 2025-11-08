package com.bank.transactions.factories;

import com.bank.transactions.Transaction;
import com.bank.transactions.serialization.TransactionSerialization;
import com.google.inject.Singleton;

@Singleton
public class TransactionSerializationFactory {

    public TransactionSerialization createTransactionSerialization(Transaction transaction) {
        TransactionSerialization transactionSerialization = new TransactionSerialization();

        transactionSerialization.uuid = transaction.getUuid();
        transactionSerialization.accountUuid = transaction.getAccountUuid();
        transactionSerialization.transactionType = transaction.getTransactionType();
        transactionSerialization.amount = transaction.getAmount();
        transactionSerialization.timestamp = transaction.getTimestamp();

        return transactionSerialization;
    }
}
