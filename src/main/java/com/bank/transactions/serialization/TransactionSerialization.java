package com.bank.transactions.serialization;

import com.bank.transactions.TransactionTypes;

import java.util.Date;

public class TransactionSerialization {
    public String uuid;

    public String accountUuid;

    public TransactionTypes transactionType;

    public double amount;

    public Date timestamp;
}
