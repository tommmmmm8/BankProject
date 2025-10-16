package com.bank.bankAccounts;

import com.bank.cards.PaymentCard;
import com.bank.people.customers.BankAccountOwner;

import java.util.HashMap;
import java.util.Map;

public class BankAccountWithPaymentCards extends BaseBankAccount {

    protected Map<String, PaymentCard> paymentCardsMap;

    public BankAccountWithPaymentCards(String uuid, String accountNumber, BankAccountOwner owner) {
        super(uuid, accountNumber, owner);

        this.paymentCardsMap = new HashMap<>();
    }

    public void addPaymentCard(PaymentCard paymentCard) {
        this.paymentCardsMap.put(paymentCard.getCardNumber(), paymentCard);
    }

    public Map<String, PaymentCard> getPaymentCardsMap() {
        return paymentCardsMap;
    }
}
