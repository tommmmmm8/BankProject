package com.bank.people.customers.factories;

import com.bank.people.BasePerson;
import com.google.inject.Singleton;

@Singleton
public class BasePersonFactory {

    public BasePerson createBasePerson(String uuid, String firstName, String lastName, int dob, String gender, String address) {
        return new BasePerson(uuid, firstName, lastName, dob, gender, address);
    }

}
