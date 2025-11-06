package com.bank.cards.services;

import com.bank.bankAccounts.managers.BankAccountsManager;
import com.bank.bankAccounts.BankAccountWithPaymentCards;
import com.bank.bankAccounts.services.BankAccountService;
import com.bank.cards.PaymentCard;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class PaymentCardService {

    @Inject
    private BankAccountService bankAccountService;

    @Inject
    private BankAccountsManager bankAccountsManager;

    public void pay(PaymentCard paymentCard, double amount) {
        BankAccountWithPaymentCards bankAccountWithPaymentCards = bankAccountsManager.findBankAccountByPaymentCard(paymentCard);
        if (bankAccountWithPaymentCards == null) throw new IllegalArgumentException("Bank account not found for the provided payment card.");

        bankAccountService.withdraw(bankAccountWithPaymentCards, amount, paymentCard);
    }
}
