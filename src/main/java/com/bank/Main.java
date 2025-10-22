package com.bank;

import com.bank.bankAccounts.BankAccount;
import com.bank.bankAccounts.BankAccountDatabase;
import com.bank.bankAccounts.BaseBankAccount;
import com.bank.bankAccounts.factories.BankAccountFactory;
import com.bank.bankAccounts.services.BankAccountService;
import com.bank.cards.PaymentCard;
import com.bank.cards.PaymentCardFactory;
import com.bank.cards.PaymentCardService;
import com.bank.people.customers.BankAccountOwner;
import com.bank.people.BasePerson;
import com.bank.people.customers.factories.BasePersonFactory;
import com.bank.people.customers.factories.CustomerFactory;

public class Main {
    public static void main(String[] args) {

        BasePersonFactory basePersonFactory = new BasePersonFactory();
        CustomerFactory customerFactory = new CustomerFactory();
        BankAccountFactory bankAccountFactory = new BankAccountFactory();
        BankAccountService bankAccountService = new BankAccountService();
        BankAccountDatabase bankAccountDatabase = new BankAccountDatabase();
        PaymentCardFactory paymentCardFactory = new PaymentCardFactory();
        PaymentCardService paymentCardService = new PaymentCardService();

        BasePerson person = basePersonFactory.createBasePerson("1", "John", "Doe", 1990, "Male", "123 Main St");
        BankAccountOwner owner = customerFactory.createBankAccountOwner("1", person);

        BankAccount bankAccount = bankAccountFactory.createBankAccount("67890", owner);
        bankAccountService.deposit(bankAccount, 500.0);
        printBankAccountBalance(bankAccount);

        PaymentCard paymentCard = paymentCardFactory.createPaymentCard(bankAccount);
        paymentCardService.pay(paymentCard, 230.0);
        printBankAccountBalance(bankAccount);

        System.out.println(bankAccountDatabase.findBankAccountByPaymentCard(paymentCard).getUuid() + " == " + bankAccount.getUuid());

//        // SavingBankAccount
//        BaseBankAccount savingAccount = bankAccountFactory.createSavingBankAccount("54321", owner);
//        new BankAccountService().deposit(savingAccount, 1000.0);
//        System.out.println("SavingBankAccount Balance: " + savingAccount.getBalance());
    }

    public static void printBankAccountBalance(BaseBankAccount bankAccount) {
        System.out.println("BankAccount Balance: " + bankAccount.getBalance());
    }
}