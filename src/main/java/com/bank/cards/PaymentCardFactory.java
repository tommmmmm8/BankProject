package com.bank.cards;

import com.bank.bankAccounts.BankAccountWithPaymentCards;
import com.bank.cards.calculators.PaymentCardExpirationCalculator;
import com.bank.cards.generators.PaymentCardCvvGenerator;
import com.bank.cards.generators.PaymentCardNumberGenerator;
import com.bank.cards.generators.PaymentCardPinGenerator;

import java.util.UUID;

public class PaymentCardFactory {

    private PaymentCardNumberGenerator paymentCardNumberGenerator = new PaymentCardNumberGenerator();
    private PaymentCardCvvGenerator paymentCardCvvGenerator = new PaymentCardCvvGenerator();
    private PaymentCardPinGenerator paymentCardPinGenerator = new PaymentCardPinGenerator();
    private PaymentCardExpirationCalculator paymentCardExpirationCalculator = new PaymentCardExpirationCalculator();

    public PaymentCard create(BankAccountWithPaymentCards bankAccount) {

        String uuid = UUID.randomUUID().toString();
        String cardNumber = paymentCardNumberGenerator.generateCardNumber();
        String cvv = paymentCardCvvGenerator.generateCvv();
        String pin = paymentCardPinGenerator.generatePin();
        String expireMonth = paymentCardExpirationCalculator.calculateMonthExpire();
        String expireYear = paymentCardExpirationCalculator.calculateYearExpire();

        PaymentCard paymentCard = new PaymentCard(uuid, cardNumber, cvv, pin, expireMonth, expireYear, bankAccount);
        bankAccount.addPaymentCard(paymentCard);
        return paymentCard;
    }
}
