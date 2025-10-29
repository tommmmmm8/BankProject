package com.bank.cards.services;

import com.bank.bankAccounts.database.BankAccountDatabase;
import com.bank.bankAccounts.BankAccountWithPaymentCards;
import com.bank.bankAccounts.services.BankAccountService;
import com.bank.cards.PaymentCard;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class PaymentCardService {

    @Inject
    BankAccountService bankAccountService;

    @Inject
    BankAccountDatabase bankAccountDatabase;

    public void pay(PaymentCard paymentCard, double amount) {
        BankAccountWithPaymentCards bankAccountWithPaymentCards = bankAccountDatabase.findBankAccountByPaymentCard(paymentCard);
        if (bankAccountWithPaymentCards == null) throw new IllegalArgumentException("Bank account not found for the provided payment card.");

        bankAccountService.withdraw(bankAccountWithPaymentCards, amount, paymentCard);
    }
}
