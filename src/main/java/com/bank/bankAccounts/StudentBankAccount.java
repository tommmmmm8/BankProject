package com.bank.bankAccounts;

import com.bank.people.BankAccountOwner;

public class StudentBankAccount extends BaseBankAccount {

    private String school;

    public StudentBankAccount(String uuid, String accountNumber, BankAccountOwner owner, String school) {
        super(uuid, accountNumber, owner);

        this.school = school;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
