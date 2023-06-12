package com.giacomini.andrea.bankkata;

import java.util.Objects;

public class Transaction {

    private final String date;
    private final int amount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (amount != that.amount) return false;
        return Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + amount;
        return result;
    }

    public Transaction(String date, int amount) {
//        throw new UnsupportedOperationException();

        this.date = date;
        this.amount = amount;
    }

    public String date() {
        return date;
    }

    public int amount(){
        return amount;
    }
}
