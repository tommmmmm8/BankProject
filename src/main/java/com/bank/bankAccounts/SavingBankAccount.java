package com.bank.bankAccounts;

import com.bank.people.BankAccountOwner;

public class SavingBankAccount extends BaseBankAccount {

    private float interestRate;

    public SavingBankAccount(String uuid, String accountNumber, BankAccountOwner owner) {
        super(uuid, accountNumber, owner);

        this.interestRate = 5;
    }
}
