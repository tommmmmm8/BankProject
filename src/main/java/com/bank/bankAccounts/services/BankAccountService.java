package com.bank.bankAccounts.services;

import com.bank.bankAccounts.BaseBankAccount;
import com.bank.cards.PaymentCard;
import com.bank.transactions.services.TransactionLogger;
import com.bank.transactions.services.TransactionTypes;
import com.bank.transactions.services.TransactionValidationService;

public class BankAccountService {

    TransactionValidationService validationService = new TransactionValidationService();
    TransactionLogger transactionLogger = new TransactionLogger();

    public void deposit(BaseBankAccount bankAccount, double amount) {
        validationService.validateDepositTransaction(amount);

        double newBalance = bankAccount.getBalance() + amount;
        bankAccount.setBalance(newBalance);
    }

    public void withdraw(BaseBankAccount bankAccount, double amount, PaymentCard paymentCard) {
        validationService.validateWithdrawalTransaction(bankAccount, amount);

        if (bankAccount.getBalance() >= amount) {
            double newBalance = bankAccount.getBalance() - amount;
            bankAccount.setBalance(newBalance);
        }

        transactionLogger.logTransaction(TransactionTypes.WITHDRAWAL, bankAccount, amount, paymentCard);
    }

    public void withdraw(BaseBankAccount bankAccount, double amount) {
        withdraw(bankAccount, amount, null);
    }

}
