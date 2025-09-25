package com.bank;

import com.bank.bankAccounts.BankAccount;
import com.bank.bankAccounts.BaseBankAccount;
import com.bank.bankAccounts.SavingBankAccount;
import com.bank.bankAccounts.StudentBankAccount;
import com.bank.people.BankAccountOwner;
import com.bank.people.BasePerson;

public class Main {
    public static void main(String[] args) {
        BasePerson person = new BasePerson("1",
                "John",
                "Doe",
                1990,
                "Male",
                "123 Main St"
        );
        BankAccountOwner owner = new BankAccountOwner("1", person);

        // BankAccount
        BaseBankAccount bankAccount = new BankAccount("2", "67890", owner);
        bankAccount.addBalance(500.0);
        System.out.println("BankAccount Balance: " + bankAccount.getBalance());
        System.out.println(bankAccount.getOwner().getPerson().getFirstName());

        // SavingBankAccount
        BaseBankAccount savingAccount = new SavingBankAccount("3", "54321", owner);
        savingAccount.addBalance(1000.0);
        System.out.println("SavingBankAccount Balance: " + savingAccount.getBalance());

        // StudentBankAccount
        BaseBankAccount studentAccount = new StudentBankAccount("4", "19380", owner, "DELTA");
        if (studentAccount instanceof StudentBankAccount studentBankAccount)
            System.out.println(studentBankAccount.getSchool());


    }
}