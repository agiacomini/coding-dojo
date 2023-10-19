package com.giacomini.andrea.arithmetics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Arithmetics {
    public static final String PATTERN_FIND_GROUP = "(\\((\\d*\\.?\\d*[-+*/]\\d*\\.?\\d*)*\\))";
    public static final String PATTERN_FIND_ROUND_BRACKETS = "\\(|\\)";
    public static final String PATTERN_FIND_SPACES = "\\s";
    public static final String PATTERN_CHECK_EVEN_PARENTHESES = "^(\\(.*\\))*$";

    public String checkTransaction(String transaction) {
        if (transactionHasEvenNumberOfParentheses(transaction)) {
            String result = parseTransaction(transaction);
            return result.equals("") ? "0" : result.replace(".0", "");
        }
        return "INVALID RECORD ERROR";
    }

    private boolean transactionHasEvenNumberOfParentheses(String transaction) {
        Matcher matcher = Pattern.compile(PATTERN_CHECK_EVEN_PARENTHESES).matcher(transaction);
        if(matcher.find())
            return true;
        return false;
    }

    private String parseTransaction(String transaction) {
        transaction = transaction.replaceAll(PATTERN_FIND_SPACES,"");
        System.out.println("transaction: " + transaction);
        while(findGroups(transaction).find()) {
            transaction = replaceGroups(findGroups(transaction),transaction);
        }
        return transaction;
    }

    private Double executeOperation(String stringOperation) {
        Operation operation = new Operation(stringOperation);
        return operation.calculate();
    }

    private Matcher findGroups(String transaction) {
        Pattern pattern = Pattern.compile(PATTERN_FIND_GROUP);
        Matcher matcher = pattern.matcher(transaction);
        return matcher;
    }

    private String replaceGroups(Matcher matcher, String transaction) {
        double result = 0;
        for (; matcher.find(); matcher.reset(transaction)) {
            result = executeOperation(removeRoundBrackets(matcher.group()));
            transaction = result != 0 ? matcher.replaceFirst(String.valueOf(result)) : matcher.replaceFirst("");
        }
        return transaction;
    }

    private String removeRoundBrackets(String string) {
        return string.replaceAll(PATTERN_FIND_ROUND_BRACKETS, "");
    }
}