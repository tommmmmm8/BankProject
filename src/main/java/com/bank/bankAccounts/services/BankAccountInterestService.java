package com.bank.bankAccounts.services;

import com.bank.bankAccounts.calculators.BankAccountInterestCalculator;
import com.bank.bankAccounts.SavingBankAccount;
import com.bank.bankAccounts.managers.BankAccountsManager;
import com.bank.logger.Logger;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.time.Instant;
import java.util.ArrayList;

@Singleton
public class BankAccountInterestService {

    @Inject
    private BankAccountsManager bankAccountDatabase;

    @Inject
    private BankAccountService bankAccountService;

    @Inject
    private BankAccountInterestCalculator bankAccountInterestCalculator;

    @Inject
    private Logger logger;

    public void handleInterest() {
        logger.log("handleInterest called");
        // Get saving accounts
        ArrayList<SavingBankAccount> savingBankAccounts = bankAccountDatabase.getBankAccountsByType(SavingBankAccount.class);
        // Determine on which saving accounts is interest going to be calculated
        ArrayList<SavingBankAccount> accountsEligibleForInterestCalculation = new ArrayList<>();
        for (SavingBankAccount savingBankAccount : savingBankAccounts)
            if (!savingBankAccount.getNextInterestCalculation().toInstant().isAfter(Instant.now()))
                accountsEligibleForInterestCalculation.add(savingBankAccount);

        for (SavingBankAccount savingBankAccount : accountsEligibleForInterestCalculation) {
            double interest = bankAccountInterestCalculator.calculateInterest(savingBankAccount);
            addInterestToAccount(savingBankAccount, interest);
        }
    }

    private void addInterestToAccount(SavingBankAccount savingBankAccount, double interest) {
        bankAccountService.deposit(savingBankAccount, interest);
        savingBankAccount.incrementNextInterestCalculation();
    }
}
