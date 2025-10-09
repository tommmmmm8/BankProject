package com.bank.bankAccounts;

import com.bank.people.customers.BankAccountOwner;

import java.util.HashMap;

public class BankAccount extends BankAccountWithPaymentCards {

    public BankAccount(String uuid, String accountNumber, BankAccountOwner owner) {
        super(uuid, accountNumber, owner);

        this.paymentCardsMap = new HashMap<>();
    }
}
