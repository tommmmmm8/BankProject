package com.bank.bankAccounts;

import com.bank.people.customers.BankAccountOwner;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;

public class SavingBankAccount extends BankAccountWithPaymentCards {

    private final float INTEREST_RATE = 5;
    private final Duration INTEREST_CALCULATION_INTERVAL = Duration.ofMinutes(1);

    private float interestRate;
    private Date nextInterestCalculation;

    public SavingBankAccount(String uuid, String accountNumber, BankAccountOwner owner) {
        super(uuid, accountNumber, owner);

        this.interestRate = INTEREST_RATE;
        this.nextInterestCalculation = Date.from(Instant.now().plus(INTEREST_CALCULATION_INTERVAL));
        this.paymentCardsMap = new HashMap<>();
    }

    public float getInterestRate() {
        return interestRate;
    }

    public Date getNextInterestCalculation() {
        return nextInterestCalculation;
    }

    public void incrementNextInterestCalculation() {
        this.nextInterestCalculation = Date.from(nextInterestCalculation.toInstant().plus(INTEREST_CALCULATION_INTERVAL));
    }
}
