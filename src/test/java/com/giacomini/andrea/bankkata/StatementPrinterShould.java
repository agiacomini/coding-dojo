package com.giacomini.andrea.bankkata;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.EMPTY_LIST;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StatementPrinterShould {

    private static final List<Transaction> NO_TRANSACTION = EMPTY_LIST;
    @Mock
    Console console;

    private StatementPrinter statementPrinter;

    @Before
    public void
    initialise(){
        statementPrinter = new StatementPrinter(console);
    }

    @Test
    public void
    always_print_the_header(){
        statementPrinter.print(NO_TRANSACTION);
        verify(console).printline("DATE || AMOUNT || BALANCE");
    }

    @Test
    public void
    print_transaction_in_reverse_chronological_order(){
        List<Transaction> transactions = transactionsContaining(
            deposit("01/04/2014", 1000),
            withdrawal("02/04/2014", 100),
            deposit("10/04/2014", 500)
        );

        statementPrinter.print(transactions);

        InOrder inOrder = inOrder(console);
        inOrder.verify(console).printline("DATE || AMOUNT || BALANCE");
        inOrder.verify(console).printline("10/04/2014 || 500,00 || 1400,00");
        inOrder.verify(console).printline("02/04/2014 || -100,00 || 900,00");
        inOrder.verify(console).printline("01/04/2014 || 1000,00 || 1000,00");

    }

    private List<Transaction> transactionsContaining(Transaction... transactions ) {
        return asList(transactions);
    }

    private Transaction withdrawal(String date, int amount) {
        return new Transaction(date, -amount);
    }

    private Transaction deposit(String date, int amount) {
        return new Transaction(date, amount);
    }
}
