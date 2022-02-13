package com.soge.domain;

import com.soge.infrastructure.TransactionRepository;

public class BankAccount {
    TransactionRepository transactionRepository;
    public BankAccount(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void doDeposit(int amount) {
        transactionRepository.doDepositTransaction(amount);
    }

    public void doWithdraw(int amount) {
        transactionRepository.doWithdrawalTransaction(amount);
    }

    public void printStatement() {
    }
}
