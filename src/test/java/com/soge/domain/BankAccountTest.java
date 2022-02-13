package com.soge.domain;


import com.soge.infrastructure.TransactionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class BankAccountTest {
    private BankAccount bankAccount;

    @Mock
    TransactionRepository transactionRepository;
    @Mock
    private StatementPrinter statementPrinter;
    private static final String TODAY = "13/02/2022";

    @Before
    public void initialise(){
        bankAccount = new BankAccount(transactionRepository, statementPrinter);
    }
    @Test
    public void do_a_deposit_transaction(){
        bankAccount.doDeposit(200);
        verify(transactionRepository).doDepositTransaction(200);


    }
    @Test
    public void do_a_withdrawal_transaction(){
        bankAccount.doWithdraw(200);
        verify(transactionRepository).doWithdrawalTransaction(200);
    }
    @Test
    public void
    print_a_statement_of_all_transactions(){
        List<Transaction> transactions = asList(new Transaction(TODAY, 200));
        when(transactionRepository.findAllTransaction()).thenReturn(transactions);
        bankAccount.printStatement();
        verify(statementPrinter).printStatement(transactions);
    }
}