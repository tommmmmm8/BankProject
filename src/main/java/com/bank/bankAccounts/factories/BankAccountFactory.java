package com.bank.bankAccounts.factories;

import com.bank.bankAccounts.BankAccount;
import com.bank.bankAccounts.SavingBankAccount;
import com.bank.bankAccounts.StudentBankAccount;
import com.bank.people.customers.BankAccountOwner;

public class BankAccountFactory {

    public BankAccount createBankAccount(String uuid, String accountNumber, BankAccountOwner owner) {
        return new BankAccount(uuid, accountNumber, owner);
    }

    public SavingBankAccount createSavingBankAccount(String uuid, String accountNumber, BankAccountOwner owner) {
        return new SavingBankAccount(uuid, accountNumber, owner);
    }

    public StudentBankAccount createStudentBankAccount(String uuid, String accountNumber, BankAccountOwner owner, String schoolName) {
        return new StudentBankAccount(uuid, accountNumber, owner, schoolName);
    }

}
