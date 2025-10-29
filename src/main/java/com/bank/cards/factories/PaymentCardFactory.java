package com.bank.cards.factories;

import com.bank.bankAccounts.BankAccountWithPaymentCards;
import com.bank.cards.PaymentCard;
import com.bank.cards.calculators.PaymentCardExpirationCalculator;
import com.bank.cards.generators.PaymentCardCvvGenerator;
import com.bank.cards.generators.PaymentCardNumberGenerator;
import com.bank.cards.generators.PaymentCardPinGenerator;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.UUID;

@Singleton
public class PaymentCardFactory {

    @Inject
    private PaymentCardNumberGenerator paymentCardNumberGenerator;

    @Inject
    private PaymentCardCvvGenerator paymentCardCvvGenerator;

    @Inject
    private PaymentCardPinGenerator paymentCardPinGenerator;

    @Inject
    private PaymentCardExpirationCalculator paymentCardExpirationCalculator;

    public PaymentCard createPaymentCard(BankAccountWithPaymentCards bankAccount) {

        String uuid = UUID.randomUUID().toString();
        String cardNumber = paymentCardNumberGenerator.generateCardNumber();
        String cvv = paymentCardCvvGenerator.generateCvv();
        String pin = paymentCardPinGenerator.generatePin();
        String expireMonth = paymentCardExpirationCalculator.calculateMonthExpire();
        String expireYear = paymentCardExpirationCalculator.calculateYearExpire();

        PaymentCard paymentCard = new PaymentCard(uuid, cardNumber, cvv, pin, expireMonth, expireYear);
        bankAccount.addPaymentCard(paymentCard);
        return paymentCard;
    }
}
