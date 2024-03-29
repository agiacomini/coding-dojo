package com.giacomini.andrea.bankkata;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;


@RunWith(MockitoJUnitRunner.class)
public class TransactionRepositoryShould {
    public static final String TODAY = "12/05/2015";
    @Mock
    private Clock clock;

    private TransactionRepository transactionRepository;

    @Before
    public void initialise(){
        transactionRepository = new TransactionRepository(clock);
        given(clock.todayAsString()).willReturn(TODAY);
    }
    @Test
    public void
    create_and_store_a_deposit_transaction(){
//        given(clock.todayAsString()).willReturn(TODAY);
        transactionRepository.addDeposit(100);

        List<Transaction> transactions = transactionRepository.allTransactions();

        assertThat(transactions.size(), is(1));
        assertThat(transactions.get(0), is(transaction(TODAY, 100)));
    }

    @Test
    public void
    create_and_store_a_withdrawal_transaction(){
//        given(clock.todayAsString()).willReturn(TODAY);
        transactionRepository.addWithdrawal(100);

        List<Transaction> transactions = transactionRepository.allTransactions();

        assertThat(transactions.size(), is(1));
        assertThat(transactions.get(0), is(transaction(TODAY, -100)));
    }

    private Transaction transaction(String date, int amount) {
//        throw new UnsupportedOperationException();
        return new Transaction(date, amount);
    }
}
