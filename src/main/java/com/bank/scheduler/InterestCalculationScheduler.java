package com.bank.scheduler;

import com.bank.bankAccounts.services.BankAccountInterestService;
import com.google.inject.Inject;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class InterestCalculationScheduler {

    @Inject
    private BankAccountInterestService interestService;

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public void start() {
        scheduler.scheduleAtFixedRate(() -> {
            try {
                interestService.handleInterest();
            } catch (Exception e) {
                e.printStackTrace(); // Log the exception
            }
        }, 0, 1, TimeUnit.MINUTES);
    }

    public void stop() {
        scheduler.shutdown();
    }
}
