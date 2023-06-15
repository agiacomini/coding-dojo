package com.giacomini.andrea.atmmachinekata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class AtmMachinePosteItaliane implements IAtmMachine {
    private List<Money> contentOfAtmMachine = new ArrayList<>();
    private int amountOfMoney;
    List<Money> moneyOfWithdraw = new ArrayList<>();
    public AtmMachinePosteItaliane(List<Money> contentOfAtmMachine) {
        this.contentOfAtmMachine = contentOfAtmMachine;
        calculateAmountOfMoney(this.contentOfAtmMachine);
    }
    Predicate<Integer> checkIfMoneyInAtmMachineAreEnoughForTheWithdraw = amountRequired -> amountRequired <= amountOfMoney;
    @Override
    public List<Money> withdraw(int moneyRequired) {

        Collections.sort(contentOfAtmMachine);
        moneyOfWithdraw.clear();
        if(checkIfMoneyInAtmMachineAreEnoughForTheWithdraw.test(moneyRequired)){
            while (moneyRequired>0){
                for (Money money: contentOfAtmMachine) {
                    if(money.quantityOfUnits > 0){
                        if(moneyRequired / money.value >= 1){
                            if(moneyOfWithdraw.isEmpty() || !moneyOfWithdraw.contains(money))
                                moneyOfWithdraw.add(new Money(money.getValue(),
                                                              money.getCurrency(),
                                                              money.getType(),
                                                 1));
                            else updateMoneyOfWithdraw(money);
                            changeQuantityOfMoneyInAtmMachine(money, -1);
                            moneyRequired -= money.value;
                            break;
                        }
                    }
                }
            }
        } else throw new UnsupportedOperationException("The ATM machine has not enough money, please go to the nearest atm machine");
        return moneyOfWithdraw;
    }

    private void updateMoneyOfWithdraw(Money moneyToAdd){
        for (Money money: moneyOfWithdraw) {
            if (money.getValue() == moneyToAdd.getValue())
                money.setQuantityOfUnits(money.getQuantityOfUnits() + 1);
        }
    }

    private void changeQuantityOfMoneyInAtmMachine(Money money, int change){
        money.setQuantityOfUnits(money.getQuantityOfUnits() + change);
    }
    public List<Money> contentOfAtmMachine(){
        return contentOfAtmMachine;
    }
    private void calculateAmountOfMoney(List<Money> moneys){
        for (Money money: moneys) {
            this.amountOfMoney += (money.quantityOfUnits > 0) ? money.value + money.quantityOfUnits : 0;
        }
    }
}