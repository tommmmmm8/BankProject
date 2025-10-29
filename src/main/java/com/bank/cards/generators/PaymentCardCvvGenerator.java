package com.bank.cards.generators;

import com.google.inject.Singleton;

@Singleton
public class PaymentCardCvvGenerator {

    public String generateCvv() {
        return String.valueOf((int) (Math.random() * 900) + 100);
    }
}
