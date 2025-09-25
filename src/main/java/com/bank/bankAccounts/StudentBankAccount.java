package com.bank.bankAccounts;

import com.bank.people.BankAccountOwner;

public class StudentBankAccount extends BaseBankAccount {

    private String schoolName;

    public StudentBankAccount(String uuid, String accountNumber, BankAccountOwner owner, String school) {
        super(uuid, accountNumber, owner);

        this.schoolName = school;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
