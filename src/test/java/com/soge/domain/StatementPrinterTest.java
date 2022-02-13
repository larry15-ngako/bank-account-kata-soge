package com.soge.domain;


import com.soge.utils.Printer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StatementPrinterTest {
    private StatementPrinter statementPrinter;
    private static final List<Transaction> EMPTY_TRANSACTION = Collections.emptyList();
    private static final String STATEMENT_HEADER = "DATE | AMOUNT | BALANCE";

    @Mock
    Printer printer;


    @Before
    public void initialise(){
        statementPrinter = new StatementPrinter(printer);
    }
    @Test
    public void should_print_first_line(){
        statementPrinter.printStatement(EMPTY_TRANSACTION);
        verify(printer).printLine(STATEMENT_HEADER);
    }

    @Test public void
    print_transactions_in_order_desc() {
        Transaction firstDepositTransaction = new Transaction("13/02/2022", 5000);
        Transaction withdrawalTransaction = new Transaction("14/02/2022", -2000);
        Transaction secondDepositTransaction = new Transaction("15/02/2022", 1000);
        List<Transaction> transactionList = asList(firstDepositTransaction, withdrawalTransaction, secondDepositTransaction);
        statementPrinter.printStatement(transactionList);
        verify(printer).printLine("DATE | AMOUNT | BALANCE");
        verify(printer).printLine("15/02/2022 | 1000,00 | 4000,00");
        verify(printer).printLine("14/02/2022 | -2000,00 | 3000,00");
        verify(printer).printLine("13/02/2022 | 5000,00 | 5000,00");

    }
}