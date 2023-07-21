package com.giacomini.andrea.fizzbuzz;

import java.util.function.Predicate;

public class FizzBuzz {
    private StringBuilder sbResult = new StringBuilder();
    Predicate<Integer> checkDivisible = number -> (number % 3 == 0) || (number % 5 == 0);
    Predicate<Integer> containsThreeOrFive = number -> String.valueOf(number).contains("3") || String.valueOf(number).contains("5");
    Predicate<Integer> checkThreeDivisible = number -> (number % 3 == 0);
    Predicate<Integer> checkFiveDivisible = number -> (number % 5 == 0);
    public String convert(int number){
        if (!checkDivisible.test(number) && !containsThreeOrFive.test(number))
            sbResult.append(String.valueOf(number));
        checkIfDivisiblePoorThreeOrFive(number);
        checkIfContainsThreeOrFive(number);
        return sbResult.toString();
    }
    private void checkIfDivisiblePoorThreeOrFive(int number){
        if (checkThreeDivisible.test(number))
            sbResult.append("Fizz");
        if (checkFiveDivisible.test(number))
            sbResult.append("Buzz");
    }
    private void checkIfContainsThreeOrFive(int number){
        if (String.valueOf(number).contains("3")){
            sbResult.append("Fizz");
        }
        if (String.valueOf(number).contains("5")){
            sbResult.append("Buzz");
        }
    }
}