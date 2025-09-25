package com.bank.helper;

import java.util.Random;

public class GenerateAccountNumber {

    public static Integer generate() {
        return new Random().nextInt(0,99999);
    }
}
