package com.soge.domain;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;



@RunWith(MockitoJUnitRunner.class)
class BankAccountTest {
    private BankAccount bankAccount;

    @Before
    public void initialise(){
        bankAccount = new BankAccount();
    }
    @Test
    public void do_a_deposit_transaction(){
        bankAccount.doDeposit(200);

    }
    @Test
    public void do_a_withdrawal_transaction(){
        bankAccount.doWithdraw(200);

    }
    @Test
    public void
    print_a_statement_of_all_transactions(){
        bankAccount.printStatement();
    }
}