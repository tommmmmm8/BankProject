package com.bank.cards;

import com.bank.bankAccounts.BankAccountWithPaymentCards;
import com.bank.bankAccounts.BaseBankAccount;
import com.bank.bankAccounts.services.BankAccountService;

public class PaymentCardService {

    BankAccountService bankAccountService = new BankAccountService();

    public void pay(PaymentCard paymentCard, double amount) {

        BankAccountWithPaymentCards bankAccount = paymentCard.getBankAccount();
        bankAccountService.withdraw(bankAccount, amount);
    }
}
