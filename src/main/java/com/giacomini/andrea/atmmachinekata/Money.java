package com.giacomini.andrea.atmmachinekata;

import java.util.Objects;

public class Money implements Comparable<Money> {
    int value;
    String currency;
    String type;
    int quantityOfUnits;
    public Money() {}
    public Money(int value, String currency, String type) {
        this.value = value;
        this.currency = currency;
        this.type = type;
    }
    public Money(int value, String currency, String type, int quantityOfUnits) {
        this.value = value;
        this.currency = currency;
        this.type = type;
        this.quantityOfUnits = quantityOfUnits;
    }
    public int getValue() {return value;}
    public void setValue(int value) {this.value = value;}
    public String getCurrency() {return currency;}
    public void setCurrency(String currency) {this.currency = currency;}
    public String getType() {return type;}
    public void setType(String type) {this.type = type;}
    public int getQuantityOfUnits() {return quantityOfUnits;}
    public void setQuantityOfUnits(int quantityOfUnits) {this.quantityOfUnits = quantityOfUnits;}


    @Override
    public String toString() {
        return "Money{" +
                "value=" + value +
                ", currency='" + currency + '\'' +
                ", type='" + type + '\'' +
                ", quantityOfUnits=" + quantityOfUnits +
                '}';
    }
    @Override
    public int compareTo(Money o) {
        return (this.value < o.value) ? 1 : ((this.value == o.value) ? 0 : -1);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        if (value != money.value) return false;
        if (!Objects.equals(currency, money.currency)) return false;
        return Objects.equals(type, money.type);
    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
