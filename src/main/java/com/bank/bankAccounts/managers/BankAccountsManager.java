package com.bank.bankAccounts.managers;

import com.bank.bankAccounts.BankAccountWithPaymentCards;
import com.bank.bankAccounts.BaseBankAccount;
import com.bank.cards.PaymentCard;
import com.google.inject.Singleton;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

@Singleton
public class BankAccountsManager {

    private static ArrayList<BaseBankAccount> bankAccounts = new ArrayList<>();

    public void addBankAccount(BaseBankAccount bankAccount) {
        if (bankAccount == null) throw new IllegalArgumentException("Bank account cannot be null");
        bankAccounts.add(bankAccount);
    }

    public void removeBankAccount(String uuid) {
        if (uuid.isEmpty()) throw new IllegalArgumentException("Uuid cannot be null");
        bankAccounts.removeIf( bankAccount -> Objects.equals(bankAccount.getUuid(), uuid));
    }

    public BaseBankAccount findBankAccountByUuid(String uuid) {
        if (uuid.isEmpty()) throw new IllegalArgumentException("Uuid cannot be null");
        return bankAccounts.stream()
                .filter(bankAccount -> Objects.equals(bankAccount.getUuid(), uuid))
                .findFirst()
                .orElse(null);
    }

    public BankAccountWithPaymentCards findBankAccountByPaymentCard(PaymentCard paymentCard) {
        if (paymentCard == null) throw new IllegalArgumentException("Payment card cannot be null");

        for (BaseBankAccount bankAccount : bankAccounts) {
            if (bankAccount instanceof BankAccountWithPaymentCards bankAccountWithPaymentCards) {
                Map<String, PaymentCard> paymentCardsOfBankAccount = bankAccountWithPaymentCards.getPaymentCardsMap();
                if (paymentCardsOfBankAccount.containsKey(paymentCard.getCardNumber()))
                    if (Objects.equals(paymentCardsOfBankAccount.get(paymentCard.getCardNumber()).getUuid(), paymentCard.getUuid()))
                        return bankAccountWithPaymentCards;
            }
        }
        return null;
    }

    public <T extends BaseBankAccount> ArrayList<T> getBankAccountsByType(Class<T> tClass) {
        ArrayList<T> accountsByType = new ArrayList<>();
        for (BaseBankAccount baseBankAccount : bankAccounts)
            if (tClass.isInstance(baseBankAccount))
                accountsByType.add(tClass.cast(baseBankAccount));

        return accountsByType;
    }

}
