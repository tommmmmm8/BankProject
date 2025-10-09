package com.bank.bankAccounts;

import com.bank.people.customers.BankAccountOwner;

import java.util.HashMap;

public class StudentBankAccount extends BankAccountWithPaymentCards {

    private String schoolName;

    public StudentBankAccount(String uuid, String accountNumber, BankAccountOwner owner, String schoolName) {
        super(uuid, accountNumber, owner);

        this.schoolName = schoolName;
        this.paymentCardsMap = new HashMap<>();
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
