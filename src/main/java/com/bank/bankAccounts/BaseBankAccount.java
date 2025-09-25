package com.bank.bankAccounts;

import com.bank.people.BankAccountOwner;

public abstract class BaseBankAccount {

    private String uuid;

    private String accountNumber;

    private BankAccountOwner owner;

    double balance;

    public BaseBankAccount(String uuid, String accountNumber, BankAccountOwner owner) {
        this.uuid = uuid;
        this.accountNumber = accountNumber;
        this.owner = owner;
    }

    public String getUuid() {
        return uuid;
    }

//    public void setUuid(String uuid) {
//        this.uuid = uuid;
//    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BankAccountOwner getOwner() {
        return owner;
    }

    public void setOwner(BankAccountOwner owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
