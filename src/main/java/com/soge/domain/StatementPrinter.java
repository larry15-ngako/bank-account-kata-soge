package com.soge.domain;

import com.soge.utils.Printer;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StatementPrinter {
    private Printer printer;
    private static final String STATEMENT_HEADER = "DATE | AMOUNT | BALANCE";
    private DecimalFormat decimalFormat = new DecimalFormat("#.00");
    public StatementPrinter(Printer printer) {
        this.printer = printer;
    }

    public void printStatement(List<Transaction> transactions) {
        printFirstLine();
        statementLines(transactions);
    }
    private void statementLines(List<Transaction> transactionList) {
        AtomicInteger result  = new AtomicInteger(0);
        transactionList
                .stream()
                .map(transaction -> statementLine(result, transaction))
                .collect(Collectors.toCollection(LinkedList::new))
                .descendingIterator()
                .forEachRemaining(printer::printLine);
    }
    public void printFirstLine(){
        printer.printLine(STATEMENT_HEADER);
    }
    public String statementLine(AtomicInteger result, Transaction t) {
        return t.date() + " | " + formatDecimal(t.amount()) +  " | " + formatDecimal(result.addAndGet(t.amount()));
    }

    private String formatDecimal(int amount) {
        return decimalFormat.format(amount);
    }
}
