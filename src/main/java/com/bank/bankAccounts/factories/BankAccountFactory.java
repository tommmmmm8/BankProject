package com.bank.bankAccounts.factories;

import com.bank.bankAccounts.BankAccount;
import com.bank.bankAccounts.SavingBankAccount;
import com.bank.bankAccounts.StudentBankAccount;
import com.bank.bankAccounts.generators.AccountNumberGenerator;
import com.bank.people.customers.BankAccountOwner;

public class BankAccountFactory {

    public BankAccount createBankAccount(String uuid, BankAccountOwner owner) {
        String accountNumber = AccountNumberGenerator.generate();
        return new BankAccount(uuid, accountNumber, owner);
    }

    public SavingBankAccount createSavingBankAccount(String uuid, BankAccountOwner owner) {
        String accountNumber = AccountNumberGenerator.generate();
        return new SavingBankAccount(uuid, accountNumber, owner);
    }

    public StudentBankAccount createStudentBankAccount(String uuid, BankAccountOwner owner, String schoolName) {
        String accountNumber = AccountNumberGenerator.generate();
        return new StudentBankAccount(uuid, accountNumber, owner, schoolName);
    }

}
