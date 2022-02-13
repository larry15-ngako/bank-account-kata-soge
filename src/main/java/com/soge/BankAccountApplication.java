package com.soge;

import com.soge.domain.BankAccount;
import com.soge.domain.StatementPrinter;
import com.soge.infrastructure.TransactionRepository;
import com.soge.utils.Clock;
import com.soge.utils.Printer;

public class BankAccountApplication {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Clock clock = new Clock();
        StatementPrinter statementPrinter = new StatementPrinter(printer);
        TransactionRepository transactionRepository = new TransactionRepository(clock);

        BankAccount bankAccount = new BankAccount(transactionRepository, statementPrinter);

        bankAccount.doDeposit(5000);
        bankAccount.doWithdraw(2000);
        bankAccount.doDeposit(1000);

        bankAccount.printStatement();
    }
}
