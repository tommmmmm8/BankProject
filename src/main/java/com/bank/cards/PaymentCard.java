package com.bank.cards;

public class PaymentCard {

    private String uuid;

    private String cardNumber;

    private String ccv;

//    private String cardHolderName;

    private String pin;

    private String expireMonth;

    private String expireYear;

    public PaymentCard(String uuid, String cardNumber, String ccv, String pin, String expireMonth, String expireYear) {
        this.uuid = uuid;
        this.cardNumber = cardNumber;
        this.ccv = ccv;
        this.pin = pin;
        this.expireMonth = expireMonth;
        this.expireYear = expireYear;
    }

    public String getUuid() {
        return uuid;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCcv() {
        return ccv;
    }

    public String getPin() {
        return pin;
    }

    public String getExpireMonth() {
        return expireMonth;
    }

    public String getExpireYear() {
        return expireYear;
    }
}
