package com.giacomini.andrea.romannumerals;

public class RomanNumerals {
    public static String romanFor(int decimal){
        String roman = "";

        for(RomanToDecimal romanToDecimal: RomanToDecimal.values()){
            while(decimal >= romanToDecimal.decimal){
                roman += romanToDecimal.roman;
                decimal -= romanToDecimal.decimal;
            }
        }
//        if(decimal >= 10){
//            roman += "X";
//            decimal -= 10;
//        }
//        if(decimal >= 5){
//            roman += "V";
//            decimal -= 5;
//        }
//        for(int i = 0; i < decimal; ++i){
//            roman += "I";
//        }
        System.out.println(roman);
        return roman;
//        if(decimal == 3){
//            return "III";
//        }
//        if(decimal == 2){
//            return "II";
//        }
//        return "I";
    }

    enum RomanToDecimal{
        THOUSAND("M", 1000),
        NINE_HUNDRED("CM", 900),
        FIVE_HUNDRED("D", 500),
        FOUR_HUNDRED("CD", 400),
        HUNDRED("C", 100),
        NINETY("XC", 90),
        FIFTY("L", 50),
        FOURTY("XL", 40),
        TEN("X", 10),
        NINE("IX", 9),
        FIVE("V", 5),
        FOUR("IV", 4),
        ONE("I", 1);

        private final String roman;
        private final int decimal;
        RomanToDecimal(String roman, int decimal) {
            this.roman = roman;
            this.decimal = decimal;
        }
    }
}
