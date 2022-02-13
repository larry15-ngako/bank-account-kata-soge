package com.soge.infrastructure;


import com.soge.domain.Transaction;
import com.soge.utils.Clock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class TransactionRepositoryTest {
    private TransactionRepository transactionRepository;
    @Mock
    Clock clock;
    public static final String TODAY = "13/02/2022";
    @Before
    public void initialise() {
        transactionRepository = new TransactionRepository(clock);
        when(clock.todayAsString()).thenReturn(TODAY);
    }
    @Test
    public void should_Do_Deposit(){

        transactionRepository.doDepositTransaction(200);
        List<Transaction> transactionList = transactionRepository.findAllTransaction();
        assertThat(transactionList.size(), is(1));
        assertThat(transactionList.get(0), is(new Transaction(TODAY, 200)));


    }

    @Test
    public void should_Do_Withdrawal_transaction(){

        transactionRepository.doWithdrawalTransaction(200);
        List<Transaction> transactionList = transactionRepository.findAllTransaction();
        assertThat(transactionList.size(), is(1));
        assertThat(transactionList.get(0), is(new Transaction(TODAY, -200)));


    }

    @Test
    public void should_get_all_transactions(){

        transactionRepository.findAllTransaction();
    }
}