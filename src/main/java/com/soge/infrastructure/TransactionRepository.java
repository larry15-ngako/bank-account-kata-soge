package com.soge.infrastructure;

import com.soge.domain.Transaction;
import com.soge.utils.Clock;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {
    private Clock clock;
    private List<Transaction> transactionList = new ArrayList<>();
    public TransactionRepository(Clock clock) {
        this.clock = clock;
    }
    public void doDepositTransaction(int amount) {
        Transaction depositTransaction = new Transaction(clock.todayAsString(), amount);
        transactionList.add(depositTransaction);
    }

    public void doWithdrawalTransaction(int amount) {
        Transaction withdrawalTransaction = new Transaction(clock.todayAsString(), -amount);
        transactionList.add(withdrawalTransaction);
    }

    public List<Transaction> findAllTransaction() {
        return transactionList;
    }
}
