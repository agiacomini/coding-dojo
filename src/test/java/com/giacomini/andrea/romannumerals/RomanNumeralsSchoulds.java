package com.giacomini.andrea.romannumerals;

import org.junit.jupiter.api.Test;

import static com.giacomini.andrea.romannumerals.RomanNumerals.romanFor;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RomanNumeralsSchoulds {

    @Test
    public void generate_a_roman_numeral_from_a_given_decinaml(){
        assertThat(romanFor(1), is("I"));
        assertThat(romanFor(2), is("II"));
        assertThat(romanFor(3), is("III"));
        assertThat(romanFor(4), is("IV"));
        assertThat(romanFor(5), is("V"));
        assertThat(romanFor(7), is("VII"));
        assertThat(romanFor(9), is("IX"));
        assertThat(romanFor(10), is("X"));
        assertThat(romanFor(18), is("XVIII"));
        assertThat(romanFor(30), is("XXX"));

        assertThat(romanFor(2687), is("MMDCLXXXVII"));
        assertThat(romanFor(3499), is("MMMCDXCIX"));
    }
}
