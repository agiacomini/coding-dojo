package com.giacomini.andrea.bankkata;

public class Account {
    private TransactionRepository transactionRepository;
    private StatementPrinter statementPrinter;
    public Account(TransactionRepository transactionRepository, StatementPrinter statementPrinter) {
        this.transactionRepository = transactionRepository;
        this.statementPrinter = statementPrinter;
    }

    public void deposit(int amount) {
//        throw new UnsupportedOperationException();
        transactionRepository.addDeposit(amount);
    }

    public void withdraw(int amount) {
//        throw new UnsupportedOperationException();
        transactionRepository.addWithdrawal(amount);
    }

    public void printStatement() {
//        throw new UnsupportedOperationException();
        statementPrinter.print(transactionRepository.allTransactions());
    }
}
