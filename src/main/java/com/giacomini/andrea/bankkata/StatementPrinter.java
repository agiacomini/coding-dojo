package com.giacomini.andrea.bankkata;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StatementPrinter {

    private static final String STATEMENT_HEADER = "DATE || AMOUNT || BALANCE";
    private DecimalFormat decimalFormatter = new DecimalFormat("#.00");
    private final Console console;

    public StatementPrinter(Console console) {
        this.console = console;
    }

    public void print(List<Transaction> transactions) {
//        throw new UnsupportedOperationException();

        console.printline(STATEMENT_HEADER);
        printStatementLines(transactions);
    }

    private void printStatementLines(List<Transaction> transactions) {
        AtomicInteger runningBalance = new AtomicInteger(0);
        transactions.stream()
                .map(transaction -> statementLine(transaction, runningBalance))
                .collect(Collectors.toCollection(LinkedList::new))
                .descendingIterator()
                .forEachRemaining(console::printline);
    }

    private String statementLine(Transaction transaction, AtomicInteger runningBalance) {
        return transaction.date()
                + " || "
                + decimalFormatter.format(transaction.amount())
                + " || "
                + decimalFormatter.format(runningBalance.addAndGet(transaction.amount()));

//        String result = transaction.date()
//                + " || "
//                + decimalFormatter.format(transaction.amount())
//                + " || "
//                + decimalFormatter.format(runningBalance.addAndGet(transaction.amount()));
//        System.out.println(result);
//        return result;
    }
}
