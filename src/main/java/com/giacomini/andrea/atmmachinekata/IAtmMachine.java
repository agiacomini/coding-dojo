package com.giacomini.andrea.atmmachinekata;

import java.util.List;

public interface IAtmMachine {
    public List<Money> withdraw(int quantity);
}
