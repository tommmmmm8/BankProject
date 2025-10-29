package com.bank.bankAccounts.services;

import com.bank.bankAccounts.BaseBankAccount;
import com.bank.cards.PaymentCard;
import com.bank.logger.ConsoleLogger;
import com.bank.transactions.services.TransactionLogMessageCreator;
import com.bank.transactions.services.TransactionTypes;
import com.bank.transactions.services.TransactionValidationService;

public class BankAccountService {

    TransactionValidationService validationService = new TransactionValidationService();
    TransactionLogMessageCreator transactionLogMessageCreator = new TransactionLogMessageCreator();
    ConsoleLogger consoleLogger = new ConsoleLogger();

    public void deposit(BaseBankAccount bankAccount, double amount) {
        validationService.validateDepositTransaction(amount);

        double newBalance = bankAccount.getBalance() + amount;
        bankAccount.setBalance(newBalance);
        consoleLogger.log(transactionLogMessageCreator.createMessage(TransactionTypes.DEPOSIT, bankAccount, amount));
    }

    public void withdraw(BaseBankAccount bankAccount, double amount, PaymentCard paymentCard) {
        validationService.validateWithdrawalTransaction(bankAccount, amount);

        if (bankAccount.getBalance() >= amount) {
            double newBalance = bankAccount.getBalance() - amount;
            bankAccount.setBalance(newBalance);
        }

        String paymentCardNumber = paymentCard != null ? paymentCard.getCardNumber() : null;
        consoleLogger.log(transactionLogMessageCreator.createMessage(TransactionTypes.WITHDRAWAL, bankAccount, amount, paymentCardNumber));
    }

    public void withdraw(BaseBankAccount bankAccount, double amount) {
        withdraw(bankAccount, amount, null);
    }

}
