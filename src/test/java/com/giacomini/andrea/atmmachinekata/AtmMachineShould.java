package com.giacomini.andrea.atmmachinekata;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class AtmMachineShould {

    private List<Money> contentOfAtmMachine;
    @Mock
    private AtmMachinePosteItaliane atmMachine;

    private List<Money> returnedMoney;
    private int request;
    @Before
    public void
    initialise(){
        contentOfAtmMachine = new ArrayList<>();
        contentOfAtmMachine.add(new Money(500, "euro", "bill", 2));
        contentOfAtmMachine.add(new Money(200, "euro", "bill", 3));
        contentOfAtmMachine.add(new Money(100, "euro", "bill", 5));
        contentOfAtmMachine.add(new Money(50, "euro", "bill", 12));
        contentOfAtmMachine.add(new Money(20, "euro", "bill", 20));
        contentOfAtmMachine.add(new Money(10, "euro", "bill", 50));
        contentOfAtmMachine.add(new Money(5, "euro", "bill", 100));
        contentOfAtmMachine.add(new Money(2, "euro", "coin", 250));
        contentOfAtmMachine.add(new Money(1, "euro", "coin", 500));

        atmMachine = new AtmMachinePosteItaliane(contentOfAtmMachine);

        returnedMoney = new ArrayList<>();
    }

    @Test
    public void
    preleva_quantita_di_soldi_disponibile(){
        request = 210;
        Money moneyOne = new Money(200, "euro", "bill");
        Money moneyTwo = new Money(10, "euro", "bill");
        returnedMoney.add(moneyOne);
        returnedMoney.add(moneyTwo);
        assertThat(atmMachine.withdraw(request), is(returnedMoney));
    }

    @Test
    public void
    preleva_quantita_di_soldi_disponibile_2(){
        request = 434;
        Money money200 = new Money(200, "euro", "bill", 2);
        Money money20 = new Money(20, "euro", "bill", 1);
        Money money10 = new Money(10, "euro", "bill", 1);
        Money money2 = new Money(2, "euro", "coin", 2);
        returnedMoney.add(money200);
        returnedMoney.add(money20);
        returnedMoney.add(money10);
        returnedMoney.add(money2);
        assertThat(atmMachine.withdraw(request), is(returnedMoney));
    }

    @Test
    public void
    tentativo_di_prelievo_di_soldi_non_disponibili(){
        request = 1900;
        returnedMoney = new ArrayList<>();
        Money money500 = new Money(500, "euro", "bill", 3);
        Money money200 = new Money(200, "euro", "bill", 2);
        returnedMoney.add(money500);
        returnedMoney.add(money200);
        assertThrows(UnsupportedOperationException.class, () -> atmMachine.withdraw(request));
    }

    @Test
    public void
    doppio_prelievo(){
        request = 1725;

        Money money500 = new Money(500, "euro", "bill", 2);
        Money money200 = new Money(200, "euro", "bill", 3);
        Money money100 = new Money(100, "euro", "bill", 1);
        Money money20 = new Money(20, "euro", "bill", 1);
        Money money5 = new Money(5, "euro", "bill", 1);

        returnedMoney.add(money500);
        returnedMoney.add(money200);
        returnedMoney.add(money100);
        returnedMoney.add(money20);
        returnedMoney.add(money5);

        assertThat(atmMachine.withdraw(request), is(returnedMoney));

        request = 1825;

        returnedMoney.clear();
        Money money100_1 = new Money(100, "euro", "bill", 4);
        Money money50_1 = new Money(50, "euro", "bill", 12);
        Money money20_1 = new Money(20, "euro", "bill", 19);
        Money money10_1 = new Money(10, "euro", "bill", 44);
        Money money5_1 = new Money(5, "euro", "bill", 1);
        returnedMoney.add(money100_1);
        returnedMoney.add(money50_1);
        returnedMoney.add(money20_1);
        returnedMoney.add(money10_1);
        returnedMoney.add(money5_1);

        assertThat(atmMachine.withdraw(request), is(returnedMoney));
    }
}