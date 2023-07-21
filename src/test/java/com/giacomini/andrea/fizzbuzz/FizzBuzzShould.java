package com.giacomini.andrea.fizzbuzz;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

public class FizzBuzzShould {
//    @Test
//    void convert_1_to_1(){
//        assertEquals("1", new FizzBuzz().convert(1));
//    }
//
//    @Test
//    void convert_2_to_2(){
//        assertEquals("2", new FizzBuzz().convert(2));
//    }
//
//    @Test
//    void convert_4_to_4(){
//        assertEquals("4", new FizzBuzz().convert(4));
//    }

//    @Test
//    void convert_3_to_Fizz(){
//        assertEquals("Fizz", new FizzBuzz().convert(3));
//    }
//
//    @Test
//    void convert_15_to_FizzBuzz(){
//        assertEquals("FizzBuzz", new FizzBuzz().convert(15));
//    }

    @ParameterizedTest
    @CsvSource({"1,1", "2,2", "4,4"})
    void convert_number_to_FizzBuzz_string(int input, String expectedOutput){
        assertEquals(expectedOutput, new FizzBuzz().convert(input));
    }

    @ParameterizedTest
    @CsvSource({"1,1", "2,2", "3, FizzFizz", "4,4", "5,BuzzBuzz", "6,Fizz", "7,7", "8,8", "9,Fizz", "10,Buzz", "11,11", "12,Fizz", "13,Fizz", "14,14", "15,FizzBuzzBuzz"})
    void convert_number_to_FizzBuzz_string_2(int input, String expectedOutput){
        assertEquals(expectedOutput, new FizzBuzz().convert(input));
    }

    @Test
    void convert_number_to_FizzBuzz_string_3(){
        assertEquals("1", new FizzBuzz().convert(1));
        assertEquals("2", new FizzBuzz().convert(2));
//        assertEquals("Fizz", new FizzBuzz().convert(3));
        assertEquals("FizzFizz", new FizzBuzz().convert(3));
        assertEquals("4", new FizzBuzz().convert(4));
        assertEquals("BuzzBuzz", new FizzBuzz().convert(5));
        assertEquals("Fizz", new FizzBuzz().convert(6));
        assertEquals("7", new FizzBuzz().convert(7));
        assertEquals("8", new FizzBuzz().convert(8));
        assertEquals("Fizz", new FizzBuzz().convert(9));
        assertEquals("Buzz", new FizzBuzz().convert(10));
        assertEquals("11", new FizzBuzz().convert(11));
        assertEquals("Fizz", new FizzBuzz().convert(12));
//        assertEquals("13", new FizzBuzz().convert(13));
        assertEquals("Fizz", new FizzBuzz().convert(13));
        assertEquals("14", new FizzBuzz().convert(14));
        assertEquals("FizzBuzzBuzz", new FizzBuzz().convert(15));
        assertEquals("Fizz", new FizzBuzz().convert(23));
    }

    @Test
    void convert(){
        assertEquals("1", new FizzBuzz().convert(1));
        assertEquals("2", new FizzBuzz().convert(2));
        assertEquals("FizzFizz", new FizzBuzz().convert(3));
        assertEquals("4", new FizzBuzz().convert(4));
        assertEquals("BuzzBuzz", new FizzBuzz().convert(5));
        assertEquals("Fizz", new FizzBuzz().convert(6));
        assertEquals("7", new FizzBuzz().convert(7));
        assertEquals("8", new FizzBuzz().convert(8));
        assertEquals("Fizz", new FizzBuzz().convert(9));
        assertEquals("Buzz", new FizzBuzz().convert(10));
        assertEquals("11", new FizzBuzz().convert(11));
        assertEquals("Fizz", new FizzBuzz().convert(12));
        assertEquals("Fizz", new FizzBuzz().convert(13));
        assertEquals("14", new FizzBuzz().convert(14));
        assertEquals("FizzBuzzBuzz", new FizzBuzz().convert(15));
        assertEquals("Fizz", new FizzBuzz().convert(23));
    }

    private static Object[][] dataProvider(){
        return new Object[][]{
                {1, "1"},
                {2, "2"},
                {3, "FizzFizz"},
                {4, "4"},
                {5, "BuzzBuzz"},
                {6, "Fizz"},
                {7, "7"},
                {8, "8"},
                {9, "Fizz"},
                {10, "Buzz"},
                {11, "11"},
                {12, "Fizz"},
                {13, "Fizz"},
                {14, "14"},
                {15, "FizzBuzzBuzz"}
        };
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void dataProviderTest(int number, String expectedResult){
        FizzBuzz fizzBuzz = new FizzBuzz();
        String actualResult = fizzBuzz.convert(number);
        assertEquals(expectedResult, actualResult);
    }
}