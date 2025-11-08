package com.bank.serialization;

import com.bank.people.customers.BankAccountOwner;
import com.bank.people.serialization.BankAccountOwnerSerialization;
import com.bank.people.customers.factories.BankAccountSerializationFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class BankAccountOwnerXmlSerializationService implements Serialization {

    @Inject
    BankAccountSerializationFactory bankAccountSerializationFactory;

    @Inject
    XmlMapper xmlMapper;

    @Override
    public String serialize(Object bankAccountOwner) {
        if (!(bankAccountOwner instanceof BankAccountOwner)) {
            throw new IllegalArgumentException("BankAccountOwner must be of type BankAccountOwner");
        }

        BankAccountOwnerSerialization bankAccountOwnerSerialization = bankAccountSerializationFactory.createBankAccountOwnerSerialization((BankAccountOwner) bankAccountOwner);

        try {
            return xmlMapper.writeValueAsString(bankAccountOwnerSerialization);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object deserialize(String bankAccountOwner) {
        try {
            return xmlMapper.readValue(bankAccountOwner, BankAccountOwnerSerialization.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
