package com.bank.people.serialization;

import com.bank.people.customers.BankAccountOwner;
import com.google.inject.Singleton;

@Singleton
public class BankAccountSerializationFactory {

    public BankAccountOwnerSerialization createBankAccountOwnerSerialization(BankAccountOwner bankAccountOwner) {
        BankAccountOwnerSerialization bankAccountOwnerSerialization = new BankAccountOwnerSerialization();

        bankAccountOwnerSerialization.uuid = bankAccountOwner.getUuid();
        bankAccountOwnerSerialization.firstName = bankAccountOwner.getPerson().getFirstName();
        bankAccountOwnerSerialization.lastName = bankAccountOwner.getPerson().getLastName();

        return bankAccountOwnerSerialization;
    }
}
