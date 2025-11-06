package com.bank.transactions;

import java.util.Date;

public class Transaction {

    private String uuid;

    private String accountUuid;

    private TransactionTypes transactionType;

    private double amount;

    private Date timestamp;

    public Transaction(String uuid, String accountUuid, TransactionTypes transactionType, double amount, Date timestamp) {
        this.uuid = uuid;
        this.accountUuid = accountUuid;
        this.transactionType = transactionType;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public String getUuid() {
        return uuid;
    }

    public String getAccountUuid() {
        return accountUuid;
    }

    public TransactionTypes getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
