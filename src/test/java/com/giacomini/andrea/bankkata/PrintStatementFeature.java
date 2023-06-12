package com.giacomini.andrea.bankkata;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PrintStatementFeature {

    @Mock
    private Console console;
    @Mock
    private Clock clock;

    private Account account;

    @Before
    public void
    initialise(){
        TransactionRepository transactionRepository = new TransactionRepository(clock);
        StatementPrinter statementPrinter = new StatementPrinter();
        account = new Account(transactionRepository, statementPrinter);
    }
    @Test
    public void
    print_statement_containing_all_transactions(){

        account.deposit(1000);
        account.withdraw(100);
        account.withdraw(500);

        account.printStatement();

        InOrder inOrder = inOrder(console);
        inOrder.verify(console).printline("DATE || AMOUNT || BALANCE");
        inOrder.verify(console).printline("10/04/2014 || -500.00 || 400.00");
        inOrder.verify(console).printline("02/04/2014 || -100.00 || 900.00");
        inOrder.verify(console).printline("01/04/2014 || 1000.00 || 1000.00");

    }
}
