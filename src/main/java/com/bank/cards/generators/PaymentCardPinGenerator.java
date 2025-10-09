package com.bank.cards.generators;

public class PaymentCardPinGenerator {

    public String generatePin() {
        return String.valueOf((int)(Math.random() * 9000) + 1000);
    }
}
