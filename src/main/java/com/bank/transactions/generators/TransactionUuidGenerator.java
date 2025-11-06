package com.bank.transactions.generators;

import java.util.UUID;

public class TransactionUuidGenerator {

    public String generateUuid() {
        return UUID.randomUUID().toString();
    }
}
