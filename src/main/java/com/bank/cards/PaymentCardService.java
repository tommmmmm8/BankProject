package com.bank.cards;

import com.bank.bankAccounts.BankAccountDatabase;
import com.bank.bankAccounts.BankAccountWithPaymentCards;
import com.bank.bankAccounts.services.BankAccountService;

public class PaymentCardService {

    BankAccountService bankAccountService = new BankAccountService();
    BankAccountDatabase bankAccountDatabase = new BankAccountDatabase();

    public void pay(PaymentCard paymentCard, double amount) {
        BankAccountWithPaymentCards bankAccountWithPaymentCards = bankAccountDatabase.findBankAccountByPaymentCard(paymentCard);
        if (bankAccountWithPaymentCards == null) throw new IllegalArgumentException("Bank account not found for the provided payment card.");

        bankAccountService.withdraw(bankAccountWithPaymentCards, amount);
    }
}
