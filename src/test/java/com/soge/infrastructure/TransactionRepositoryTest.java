package com.soge.infrastructure;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class TransactionRepositoryTest {
    private TransactionRepository transactionRepository;

    @Before
    public void initialise() {
        transactionRepository = new TransactionRepository();
    }
    @Test
    public void should_Do_Deposit(){

        transactionRepository.doDepositTransaction(200);


    }

    @Test
    public void should_Do_Withdrawal_transaction(){

        transactionRepository.doWithdrawalTransaction(200);


    }

    @Test
    public void should_get_all_transactions(){

        transactionRepository.findAllTransaction();
    }
}