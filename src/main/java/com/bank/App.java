package com.bank;

import com.bank.bankAccounts.BankAccount;
import com.bank.bankAccounts.managers.BankAccountsManager;
import com.bank.bankAccounts.BaseBankAccount;
import com.bank.bankAccounts.factories.BankAccountFactory;
import com.bank.bankAccounts.services.BankAccountService;
import com.bank.cards.PaymentCard;
import com.bank.cards.factories.PaymentCardFactory;
import com.bank.cards.services.PaymentCardService;
import com.bank.people.BasePerson;
import com.bank.people.customers.BankAccountOwner;
import com.bank.people.customers.factories.BasePersonFactory;
import com.bank.people.customers.factories.BankAccountOwnerFactory;
import com.bank.quartzScheduling.GuiceJobFactory;
import com.bank.quartzScheduling.InterestCalculationJob;
import com.bank.quartzScheduling.QuartzSchedulerService;
import com.bank.quartzScheduling.TransactionHistoryJob;
import com.bank.schedulers.InterestCalculationScheduler;
import com.bank.transactions.Transaction;
import com.bank.transactions.services.TransactionHistoryService;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

@Singleton
public class App {

    @Inject
    BasePersonFactory basePersonFactory;

    @Inject
    BankAccountOwnerFactory bankAccountOwnerFactory;

    @Inject
    BankAccountFactory bankAccountFactory;

    @Inject
    BankAccountService bankAccountService;

    @Inject
    BankAccountsManager bankAccountsManager;

    @Inject
    PaymentCardFactory paymentCardFactory;

    @Inject
    PaymentCardService paymentCardService;

    @Inject
    GuiceJobFactory guiceJobFactory;

    @Inject
    QuartzSchedulerService quartzSchedulerService;

    public void run() {
        BasePerson person = basePersonFactory.createBasePerson("1", "John", "Doe", 1990, "Male", "123 Main St");
        BankAccountOwner owner = bankAccountOwnerFactory.createBankAccountOwner("1", person);

        BankAccount bankAccount = bankAccountFactory.createBankAccount("67890", owner);
        bankAccountService.deposit(bankAccount, 500.0);
        printBankAccountBalance(bankAccount);

        bankAccountService.withdraw(bankAccount, 100);

        PaymentCard paymentCard = paymentCardFactory.createPaymentCard(bankAccount);
        paymentCardService.pay(paymentCard, 230.0);
        printBankAccountBalance(bankAccount);

        System.out.println(bankAccountsManager.findBankAccountByPaymentCard(paymentCard).getUuid() + " == " + bankAccount.getUuid());

        // SavingBankAccount
        BaseBankAccount savingAccount = bankAccountFactory.createSavingBankAccount("54321", owner);
        bankAccountService.deposit(savingAccount, 1000.0);
        System.out.println("SavingBankAccount Balance: " + savingAccount.getBalance());

        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            // Set the GuiceJobFactory to allow Quartz to create job instances with dependencies injected by Guice

            scheduler.setJobFactory(guiceJobFactory);
            scheduler.start();

            quartzSchedulerService.scheduleJob(scheduler, InterestCalculationJob.class, "group1", 1);
            quartzSchedulerService.scheduleJob(scheduler, TransactionHistoryJob.class, "group1", 1);
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printBankAccountBalance(BaseBankAccount bankAccount) {
        System.out.println("BankAccount Balance: " + bankAccount.getBalance());
    }
}
