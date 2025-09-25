package com.bank.bankAccounts;

import com.bank.people.BankAccountOwner;

public class BankAccount extends BaseBankAccount {

    public BankAccount(String uuid, String accountNumber, BankAccountOwner owner) {
        super(uuid, accountNumber, owner);
    }
}
