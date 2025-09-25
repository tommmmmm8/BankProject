package com.bank.bankAccounts.generators;

import java.util.Random;

public class AccountNumberGenerator {

    public static String generate() {
        return new Random().nextInt(0,99999) + "";
    }
}
