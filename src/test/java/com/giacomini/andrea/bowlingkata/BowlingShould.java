package com.giacomini.andrea.bowlingkata;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BowlingShould {
    private Bowling bowling;
    @Before
    public void
    initialise(){
        bowling = new Bowling();
    }
    @Test
    public void
    get_zero_results(){
        assertThat(bowling.calculateScore("-- -- -- -- -- -- -- -- -- --"),is(0));
    }
    @Test
    public void
    get_zero_one(){
        assertThat(bowling.calculateScore("1- -- -- -- -- -- -- -- -- --"),is(1));
    }
    @Test
    public void
    get_ninety_result(){
        assertThat(bowling.calculateScore("9- 9- 9- 9- 9- 9- 9- 9- 9- 9-"),is(90));
    }
    @Test
    public void
    get_spare_result(){
        assertThat(bowling.calculateScore("9/ -- -- -- -- -- -- -- -- --"),is(10));
    }
    @Test
    public void
    get_strike_result(){
        assertThat(bowling.calculateScore("X -- -- -- -- -- -- -- -- --"),is(10));
    }
    @Test
    public void
    get_spare_every_frame(){
        assertThat(bowling.calculateScore("5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5"),is(150));
    }
    @Test
    public void
    get_strike_every_frame(){
        assertThat(bowling.calculateScore("X X X X X X X X X X X X"),is(300));
    }
}