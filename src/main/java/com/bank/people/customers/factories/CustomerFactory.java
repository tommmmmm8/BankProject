package com.bank.people.customers.factories;

import com.bank.people.BasePerson;
import com.bank.people.customers.BankAccountOwner;
import com.google.inject.Singleton;

@Singleton
public class CustomerFactory {

    public BankAccountOwner createBankAccountOwner(String uuid, BasePerson person) {
        return new BankAccountOwner(uuid, person);
    }
}
