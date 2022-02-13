package com.soge.acceptance;

import com.soge.domain.BankAccount;
import com.soge.domain.StatementPrinter;
import com.soge.infrastructure.TransactionRepository;
import com.soge.utils.Clock;
import com.soge.utils.Printer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PrintStatementTest {
    private BankAccount bankAccount;
    @Mock
    Printer printer;
    @Mock
    Clock clock;



    @Before
    public void initialise() {
        TransactionRepository transactionRepository = new TransactionRepository(clock);
        StatementPrinter statementPrinter = new StatementPrinter(printer);
        bankAccount = new BankAccount(transactionRepository, statementPrinter);
    }
    @Test
    public void
    should_print_statement_of_all_transactions() {
        when(clock.todayAsString()).thenReturn("13/02/2022", "14/02/2022", "15/02/2022");
        bankAccount.doDeposit(5000);
        bankAccount.doWithdraw(2000);
        bankAccount.doDeposit(1000);
        bankAccount.printStatement();
        verify(printer).printLine("DATE | AMOUNT | BALANCE");
        verify(printer).printLine("15/02/2022 | 1000,00 | 4000,00");
        verify(printer).printLine("14/02/2022 | -2000,00 | 3000,00");
        verify(printer).printLine("13/02/2022 | 5000,00 | 5000,00");
    }
}
