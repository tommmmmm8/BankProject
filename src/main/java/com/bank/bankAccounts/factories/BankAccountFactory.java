package com.bank.bankAccounts.factories;

import com.bank.bankAccounts.BankAccount;
import com.bank.bankAccounts.database.BankAccountDatabase;
import com.bank.bankAccounts.SavingBankAccount;
import com.bank.bankAccounts.StudentBankAccount;
import com.bank.bankAccounts.generators.AccountNumberGenerator;
import com.bank.people.customers.BankAccountOwner;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class BankAccountFactory {

    @Inject
    BankAccountDatabase bankAccountDatabase;

    public BankAccount createBankAccount(String uuid, BankAccountOwner owner) {
        String accountNumber = AccountNumberGenerator.generate();
        BankAccount bankAccount = new BankAccount(uuid, accountNumber, owner);
        bankAccountDatabase.addBankAccount(bankAccount);
        return bankAccount;
    }

    public SavingBankAccount createSavingBankAccount(String uuid, BankAccountOwner owner) {
        String accountNumber = AccountNumberGenerator.generate();
        SavingBankAccount savingBankAccount = new SavingBankAccount(uuid, accountNumber, owner);
        bankAccountDatabase.addBankAccount(savingBankAccount);
        return savingBankAccount;
    }

    public StudentBankAccount createStudentBankAccount(String uuid, BankAccountOwner owner, String schoolName) {
        String accountNumber = AccountNumberGenerator.generate();
        StudentBankAccount studentBankAccount = new StudentBankAccount(uuid, accountNumber, owner, schoolName);
        bankAccountDatabase.addBankAccount(studentBankAccount);
        return studentBankAccount;
    }

}
