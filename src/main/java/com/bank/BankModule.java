package com.bank;

import com.bank.logger.ConsoleLogger;
import com.bank.logger.Logger;
import com.google.inject.AbstractModule;

public class BankModule extends AbstractModule {

    @Override
    protected void configure() {
//        super.configure();
        bind(Logger.class).to(ConsoleLogger.class);
    }
}
