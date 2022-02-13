package com.soge.domain;


import com.soge.infrastructure.TransactionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
class BankAccountTest {
    private BankAccount bankAccount;

    @Mock
    TransactionRepository transactionRepository;

    @Before
    public void initialise(){
        bankAccount = new BankAccount(transactionRepository);
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
        bankAccount.printStatement();
    }
}