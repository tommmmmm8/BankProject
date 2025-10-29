package com.bank.cards.calculators;

import com.google.inject.Singleton;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Singleton
public class PaymentCardExpirationCalculator {

    private static final DateTimeFormatter MONTH_FMT = DateTimeFormatter.ofPattern("MM");
    private static final DateTimeFormatter YEAR_FMT_SHORT = DateTimeFormatter.ofPattern("yyyy");

    public String calculateMonthExpire() {
        LocalDate today = LocalDate.now();
        return today.format(MONTH_FMT);
    }

    public String calculateYearExpire() {
        LocalDate today = LocalDate.now();
        final int DEFAULT_EXPIRATION_YEAR_LENGTH = 5;
        LocalDate future = today.plusYears(DEFAULT_EXPIRATION_YEAR_LENGTH);
        return future.format(YEAR_FMT_SHORT);
    }
}
