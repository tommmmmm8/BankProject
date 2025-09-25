package com.bank.people.customers;

import com.bank.people.BasePerson;

public class BankAccountOwner {

    private String uuid;

    private BasePerson person;

    public BankAccountOwner(String uuid, BasePerson person) {
        this.uuid = uuid;
        this.person = person;
    }

    public String getUuid() {
        return uuid;
    }

//    public void setUuid(String uuid) {
//        this.uuid = uuid;
//    }


    public BasePerson getPerson() {
        return person;
    }

    public void setPerson(BasePerson person) {
        this.person = person;
    }
}
