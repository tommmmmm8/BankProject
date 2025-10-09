package com.bank.cards.generators;

public class PaymentCardCvvGenerator {

    public String generateCvv() {
        return String.valueOf((int) (Math.random() * 900) + 100);
    }
}
