package com.bank.serialization;

import com.bank.transactions.Transaction;
import com.bank.transactions.factories.TransactionSerializationFactory;
import com.bank.transactions.serialization.TransactionSerialization;
import com.google.gson.Gson;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class TransactionJsonSerializationService implements Serialization{

    @Inject
    private TransactionSerializationFactory transactionSerializationFactory;

    @Inject
    private Gson gson;

    @Override
    public String serialize(Object transaction) {
        if (!(transaction instanceof Transaction))
            throw new IllegalArgumentException("object must be of type Transaction");

        TransactionSerialization transactionSerialization = transactionSerializationFactory.createTransactionSerialization((Transaction) transaction);
        return gson.toJson(transactionSerialization);
    }

    @Override
    public Object deserialize(String serializedData) {
        return gson.fromJson(serializedData, TransactionSerialization.class);
    }
}
