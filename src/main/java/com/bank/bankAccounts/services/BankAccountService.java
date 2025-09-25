package com.bank.bankAccounts.services;

import com.bank.bankAccounts.BaseBankAccount;
import com.bank.transactions.services.TransactionValidationService;

public class BankAccountService {

    TransactionValidationService validationService = new TransactionValidationService();

    public void deposit(BaseBankAccount account, double amount) {
        validationService.validateDepositTransaction(amount);

        double newBalance = account.getBalance() + amount;
        account.setBalance(newBalance);
    }

    public void withdraw(BaseBankAccount account, double amount) {
        validationService.validateWithdrawalTransaction(account, amount);

        if (account.getBalance() >= amount) {
            double newBalance = account.getBalance() - amount;
            account.setBalance(newBalance);
        }
    }

}
