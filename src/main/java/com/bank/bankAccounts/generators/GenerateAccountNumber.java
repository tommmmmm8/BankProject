package com.bank.bankAccounts.generators;

import java.util.Random;

public class GenerateAccountNumber {

    public static String generate() {
        return new Random().nextInt(0,99999) + "";
    }
}
