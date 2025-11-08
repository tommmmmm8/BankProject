package com.bank.quartzScheduling;

import com.bank.bankAccounts.services.BankAccountInterestService;
import com.google.inject.Inject;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class InterestCalculationJob implements Job {

    @Inject
    private BankAccountInterestService bankAccountInterestService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        bankAccountInterestService.calculateAndApplyInterest();
    }
}
