package com.bank.bankAccounts.services;

import com.bank.bankAccounts.BaseBankAccount;
import com.bank.bankAccounts.managers.BankAccountsManager;
import com.bank.cards.PaymentCard;
import com.bank.logger.Logger;
import com.bank.transactions.Transaction;
import com.bank.transactions.factories.TransactionFactory;
import com.bank.transactions.managers.TransactionsManager;
import com.bank.transactions.services.TransactionLogMessageCreator;
import com.bank.transactions.TransactionTypes;
import com.bank.transactions.services.TransactionValidationService;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.Date;

@Singleton
public class BankAccountService {

    @Inject
    private TransactionValidationService validationService;

    @Inject
    private TransactionFactory transactionFactory;

    @Inject
    private TransactionLogMessageCreator transactionLogMessageCreator;

    @Inject
    private Logger logger;

    public void deposit(BaseBankAccount bankAccount, double amount) {
        validationService.validateDepositTransaction(amount);

        double newBalance = bankAccount.getBalance() + amount;
        bankAccount.setBalance(newBalance);

        Transaction transaction = transactionFactory.createTransaction(bankAccount.getUuid(), TransactionTypes.DEPOSIT, amount, new Date());
        logger.log(transactionLogMessageCreator.createMessage(transaction));
    }

    public void withdraw(BaseBankAccount bankAccount, double amount, PaymentCard paymentCard) {
        validationService.validateWithdrawalTransaction(bankAccount, amount);

        double newBalance = bankAccount.getBalance() - amount;
        bankAccount.setBalance(newBalance);

        String paymentCardNumber = paymentCard != null ? paymentCard.getCardNumber() : null;
        Transaction transaction = transactionFactory.createTransaction(bankAccount.getUuid(), TransactionTypes.WITHDRAWAL, amount, new Date());
        logger.log(transactionLogMessageCreator.createMessage(transaction, paymentCardNumber));
    }

    public void withdraw(BaseBankAccount bankAccount, double amount) {
        withdraw(bankAccount, amount, null);
    }
}
