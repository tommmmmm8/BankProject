package com.bank.bankAccounts.services;

import com.bank.bankAccounts.BaseBankAccount;
import com.bank.cards.PaymentCard;
import com.bank.logger.Logger;
import com.bank.transactions.services.TransactionLogMessageCreator;
import com.bank.transactions.services.TransactionTypes;
import com.bank.transactions.services.TransactionValidationService;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class BankAccountService {

    @Inject
    private TransactionValidationService validationService;

    @Inject
    private TransactionLogMessageCreator transactionLogMessageCreator;

    @Inject
    private Logger logger;

    public void deposit(BaseBankAccount bankAccount, double amount) {
        validationService.validateDepositTransaction(amount);

        double newBalance = bankAccount.getBalance() + amount;
        bankAccount.setBalance(newBalance);
        logger.log(transactionLogMessageCreator.createMessage(TransactionTypes.DEPOSIT, bankAccount, amount));
    }

    public void withdraw(BaseBankAccount bankAccount, double amount, PaymentCard paymentCard) {
        validationService.validateWithdrawalTransaction(bankAccount, amount);

        if (bankAccount.getBalance() >= amount) {
            double newBalance = bankAccount.getBalance() - amount;
            bankAccount.setBalance(newBalance);
        }

        String paymentCardNumber = paymentCard != null ? paymentCard.getCardNumber() : null;
        logger.log(transactionLogMessageCreator.createMessage(TransactionTypes.WITHDRAWAL, bankAccount, amount, paymentCardNumber));
    }

    public void withdraw(BaseBankAccount bankAccount, double amount) {
        withdraw(bankAccount, amount, null);
    }

}
