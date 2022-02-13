package com.soge.domain;

import com.soge.infrastructure.TransactionRepository;

public class BankAccount {
    private TransactionRepository transactionRepository;
    private StatementPrinter statementPrinter;
    public BankAccount(TransactionRepository transactionRepository, StatementPrinter statementPrinter) {
        this.transactionRepository = transactionRepository;
        this.statementPrinter = statementPrinter;
    }

    public void doDeposit(int amount) {
        transactionRepository.doDepositTransaction(amount);
    }

    public void doWithdraw(int amount) {
        transactionRepository.doWithdrawalTransaction(amount);
    }

    public void printStatement() {
        statementPrinter.printStatement(transactionRepository.findAllTransaction());
    }
}
