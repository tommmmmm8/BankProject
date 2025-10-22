package com.bank.people.customers.factories;

import com.bank.people.BasePerson;

public class BasePersonFactory {

    public BasePerson createBasePerson(String uuid, String firstName, String lastName, int dob, String gender, String address) {
        return new BasePerson(uuid, firstName, lastName, dob, gender, address);
    }

}
