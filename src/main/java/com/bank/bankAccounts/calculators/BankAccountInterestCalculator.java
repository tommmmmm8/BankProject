package com.bank.bankAccounts.calculators;

import com.bank.bankAccounts.SavingBankAccount;
import com.google.inject.Singleton;

@Singleton
public class BankAccountInterestCalculator {

    /**
     * Calculates the interest for a given saving bank account.
     * Formula: Interest = Balance * (Interest Rate / 100)
     *
     * @param savingBankAccount the saving bank account for which interest is calculated
     * @return the calculated interest
     */
    public double calculateInterest(SavingBankAccount savingBankAccount) {
        return savingBankAccount.getBalance() * (savingBankAccount.getInterestRate() / 100);
    }
}
