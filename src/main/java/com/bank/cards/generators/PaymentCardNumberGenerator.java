package com.bank.cards.generators;

import com.google.inject.Singleton;

@Singleton
public class PaymentCardNumberGenerator {

    public String generateCardNumber() {
        return String.valueOf((long) (Math.random() * 1_0000_0000_0000_0000L));
    }

    public static void main(String[] args) {
        System.out.println(new PaymentCardNumberGenerator().generateCardNumber());
    }
}
