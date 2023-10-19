package com.giacomini.andrea.arithmetics;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class ArithmeticsShould {
    private Arithmetics arithmetics;
    @Before
    public void initialise()
    {
        arithmetics = new Arithmetics();
    }
    @Test
    @Parameters({
            "( 1 + ( ( 2 + 3 ) * (4 * 5) ) ) + 1, INVALID RECORD ERROR",
            "0 + ( 5 * ( 4 * ( 3 * ( 2 * ( 1 * 9 ) / 8 - 7 ) + 6 ) ) ), INVALID RECORD ERROR",
            "((()())) + 3, INVALID RECORD ERROR",
            "3 + ( 2 * 1 ), INVALID RECORD ERROR"
    })
    public void read_transaction_of_cryptocurrency_and_return_error_message(String transactionsOfCryptocurrency, String resultOfTransaction)
    {
        assertThat(arithmetics.checkTransaction(transactionsOfCryptocurrency), is(resultOfTransaction) );
    }
    @Test
    @Parameters({
            "( 1 + ( ( 2 + 3 ) * (4 * 5) ) ), 101",
            "( 5 * ( 4 * ( 3 * ( 2 * ( 1 * 9 ) / 8 - 7 ) + 6 ) ) ), -165",
            "((()())), 0",
            "3 + ( 2 * 1 ), INVALID RECORD ERROR"
    })
    public void read_transaction_of_cryptocurrency(String transactionsOfCryptocurrency, String resultOfTransaction)
    {
        assertThat(arithmetics.checkTransaction(transactionsOfCryptocurrency), is(resultOfTransaction) );
    }
}