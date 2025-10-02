package com.bank.serialization;

import com.bank.people.BasePerson;
import com.bank.people.customers.BankAccountOwner;
import com.bank.people.serialization.BankAccountOwnerSerialization;
import com.bank.people.serialization.BankAccountSerializationFactory;

public class BankAccountOwnerJsonSerializationService implements Serialization {

    BankAccountSerializationFactory bankAccountSerializationFactory = new BankAccountSerializationFactory();

    @Override
    public String serialize(Object bankAccountOwner) {
        if (!(bankAccountOwner instanceof BankAccountOwner)) {
            throw new IllegalArgumentException("BankAccountOwner must be of type BankAccountOwner");
        }

        BankAccountOwnerSerialization bankAccountOwnerSerialization = bankAccountSerializationFactory.createBankAccountOwnerSerialization((BankAccountOwner) bankAccountOwner);

        StringBuilder builder = new StringBuilder();
        builder.append("{");
        builder.append("\"uuid\": " + bankAccountOwnerSerialization.uuid);
        builder.append(", \"firstName\": \"" + bankAccountOwnerSerialization.firstName + "\"");
        builder.append(", \"lastName\": \"" + bankAccountOwnerSerialization.lastName + "\"");
        builder.append("}");

        return builder.toString();
    }

    @Override
    public Object deserialize(String object) {
        return null;
    }

    public static void main(String[] args) {
        BankAccountOwnerJsonSerializationService service = new BankAccountOwnerJsonSerializationService();
        System.out.println(service.serialize(new BankAccountOwner("101", new BasePerson("100", "Tom", "Chrtek", 1, "man", "123 Main street"))));
    }
}
