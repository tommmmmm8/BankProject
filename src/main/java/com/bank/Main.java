package com.bank;

import com.bank.bankAccounts.BankAccount;
import com.bank.bankAccounts.BaseBankAccount;
import com.bank.bankAccounts.SavingBankAccount;
import com.bank.bankAccounts.StudentBankAccount;
import com.bank.factories.BankAccountFactory;
import com.bank.service.BankAccountService;
import com.bank.service.GenerateAccountNumber;
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

        BankAccountFactory bankAccountFactory = new BankAccountFactory();

        // BankAccount
        BaseBankAccount bankAccount = bankAccountFactory.createBankAccount("2", "67890", owner);
        new BankAccountService().deposit(bankAccount, 500.0);
        System.out.println("BankAccount Balance: " + bankAccount.getBalance());
        System.out.println(bankAccount.getOwner().getPerson().getFirstName());

        // SavingBankAccount
        BaseBankAccount savingAccount = bankAccountFactory.createSavingBankAccount("3", "54321", owner);
        new BankAccountService().deposit(savingAccount, 1000.0);
        System.out.println("SavingBankAccount Balance: " + savingAccount.getBalance());

        // StudentBankAccount
        String generatedAccNum = GenerateAccountNumber.generate().toString();
        System.out.println("Generated Account Number: " + generatedAccNum);
        BaseBankAccount studentAccount = bankAccountFactory.createStudentBankAccount("4", generatedAccNum, owner, "DELTA");
        if (studentAccount instanceof StudentBankAccount studentBankAccount)
            System.out.println(studentBankAccount.getSchoolName());

    }
}