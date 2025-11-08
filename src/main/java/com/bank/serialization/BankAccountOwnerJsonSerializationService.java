package com.bank.serialization;

import com.bank.people.customers.BankAccountOwner;
import com.bank.people.serialization.BankAccountOwnerSerialization;
import com.bank.people.customers.factories.BankAccountSerializationFactory;
import com.google.gson.Gson;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class BankAccountOwnerJsonSerializationService implements Serialization {

    @Inject
    private BankAccountSerializationFactory bankAccountSerializationFactory;

    @Inject
    private Gson gson;

    @Override
    public String serialize(Object bankAccountOwner) {
        if (!(bankAccountOwner instanceof BankAccountOwner))
            throw new IllegalArgumentException("object must be of type BankAccountOwner");

        BankAccountOwnerSerialization bankAccountOwnerSerialization = bankAccountSerializationFactory.createBankAccountOwnerSerialization((BankAccountOwner) bankAccountOwner);

        return gson.toJson(bankAccountOwnerSerialization);
    }

    @Override
    public Object deserialize(String serializedData) {
        return gson.fromJson(serializedData, BankAccountOwnerSerialization.class);
    }

    public static void main(String[] args) {
    }
}
