package com.bank;

import com.bank.bankAccounts.BaseBankAccount;
import com.bank.bankAccounts.StudentBankAccount;
import com.bank.bankAccounts.factories.BankAccountFactory;
import com.bank.bankAccounts.services.BankAccountService;
import com.bank.bankAccounts.generators.AccountNumberGenerator;
import com.bank.people.customers.BankAccountOwner;
import com.bank.people.BasePerson;
import com.bank.people.customers.factories.CustomerFactory;

public class Main {
    public static void main(String[] args) {

        CustomerFactory customerFactory = new CustomerFactory();
        BasePerson person = new BasePerson("1",
                "John",
                "Doe",
                1990,
                "Male",
                "123 Main St"
        );
        BankAccountOwner owner = customerFactory.createBankAccountOwner("1", person);

        BankAccountFactory bankAccountFactory = new BankAccountFactory();

        // BankAccount
        BaseBankAccount bankAccount = bankAccountFactory.createBankAccount("67890", owner);
        new BankAccountService().deposit(bankAccount, 500.0);
        System.out.println("BankAccount Balance: " + bankAccount.getBalance());
        System.out.println(bankAccount.getOwner().getPerson().getFirstName());

        // SavingBankAccount
        BaseBankAccount savingAccount = bankAccountFactory.createSavingBankAccount("54321", owner);
        new BankAccountService().deposit(savingAccount, 1000.0);
        System.out.println("SavingBankAccount Balance: " + savingAccount.getBalance());

        // StudentBankAccount
//        String generatedAccNum = AccountNumberGenerator.generate().toString();
//        System.out.println("Generated Account Number: " + generatedAccNum);
//        BaseBankAccount studentAccount = bankAccountFactory.createStudentBankAccount("4", generatedAccNum, owner, "DELTA");
//        if (studentAccount instanceof StudentBankAccount studentBankAccount)
//            System.out.println(studentBankAccount.getSchoolName());

    }
}