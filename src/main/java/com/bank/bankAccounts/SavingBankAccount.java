package com.bank.bankAccounts;

import com.bank.people.customers.BankAccountOwner;

import java.util.HashMap;

public class SavingBankAccount extends BankAccountWithPaymentCards {

    private float interestRate;

    public SavingBankAccount(String uuid, String accountNumber, BankAccountOwner owner) {
        super(uuid, accountNumber, owner);

        this.interestRate = 5;
        this.paymentCardsMap = new HashMap<>();
    }
}
