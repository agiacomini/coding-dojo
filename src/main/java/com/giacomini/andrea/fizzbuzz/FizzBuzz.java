package com.giacomini.andrea.fizzbuzz;

public class FizzBuzz {
    public String convert(int number){
//        throw new UnsupportedOperationException("implement me!");

//        if(number == 4) return "4";
//        if(number == 2) return "2";
//        return "1";

//        if(number == 3) return "Fizz";

//        // Fizz behaviour
//        if( (number % 3) == 0 ) return "Fizz";
//
//        // Buzz behaviour
//        if( (number % 5) == 0 ) return "Buzz";

        if(String.valueOf(number).contains("3")){
            if( (number % 3) == 0 ){
                if ( (number % 5) == 0 ) {
                    System.out.println("FizzFizzBuzz");
                    return "FizzFizzBuzz";
                }
                System.out.println("FizzFizz");
                return "FizzFizz";
            } else if( (number % 5) == 0 ) {
                System.out.println("FizzBuzz");
                return "FizzBuzz";
            }
            System.out.println("Fizz");
            return "Fizz";
        } else if (String.valueOf(number).contains("5")){
            if( (number % 3) == 0 ){
                if ( (number % 5) == 0 ) {
                    System.out.println("FizzBuzzBuzz");
                    return "FizzBuzzBuzz";
                }
                System.out.println("FizzBuzz");
                return "FizzBuzz";
            } else if( (number % 5) == 0 ) {
                System.out.println("BuzzBuzz");
                return "BuzzBuzz";
            }
            System.out.println("Buzz");
            return "Buzz";
        }

        if( (number % 3) == 0 ){
            if ( (number % 5) == 0 ) {
                System.out.println("FizzBuzz");
                return "FizzBuzz";
            }
            System.out.println("Fizz");
            return "Fizz";
        } else if( (number % 5) == 0 ) {
            System.out.println("Buzz");
            return "Buzz";
        }
        System.out.println(String.valueOf(number));
        return String.valueOf(number);
    }

    private boolean containsThree(int number){
        return String.valueOf(number).contains("3");
    }

    private boolean containsFive(int number){
        return String.valueOf(number).contains("5");
    }

    private static String containsCharacter(String number, String[] items){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < items.length; i++){
            sb.append( number.contains(items[i]) ? number.charAt(number.indexOf(items[i])) : "");
        }
        return sb.toString();
    }

    private static String checkIfStringContainsThreeOrFive(StringBuilder sb, int number){
        String str = FizzBuzz.containsCharacter(String.valueOf(number), new String[]{"3","5"});
        switch (str){
            case "3": sb.append("Fizz");
                break;
            case "5": sb.append("Buzz");
                break;
            default: break;
        }
        System.out.println(sb.toString().equals("") ? number : sb.toString());
        return sb.toString();
    }

    public String convert_2(int number){
        StringBuilder sb = new StringBuilder();
        if( (number % 3) == 0 ){
            if ( (number % 5) == 0 ) {
                sb.append("FizzBuzz").toString();
                return checkIfStringContainsThreeOrFive(sb, number);
            }
            sb.append("Fizz").toString();
            return checkIfStringContainsThreeOrFive(sb, number);
        } else if( (number % 5) == 0 ) {
            sb.append("Buzz").toString();
            return checkIfStringContainsThreeOrFive(sb, number);
        }
        checkIfStringContainsThreeOrFive(sb, number);
        return sb.toString().equals("") ? sb.append(number).toString() : sb.toString();
    }
}