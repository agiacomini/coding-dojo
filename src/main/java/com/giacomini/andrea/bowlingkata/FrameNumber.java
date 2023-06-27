package com.giacomini.andrea.bowlingkata;

import java.util.ArrayList;
import java.util.function.Predicate;

public class FrameNumber extends AFrame{
    Predicate<Character> isMiss = x -> x.equals(Constants.IS_MISS);
    public FrameNumber(String frameRolls){
        rollsScoreList = new ArrayList<>(Constants.MAX_ROLLS_IN_FRAME);
        handleScore(frameRolls);
        calculateFrameScore();
    }
    private void handleScore(String singleRoleScore) {
        for (int i = 0; i < singleRoleScore.length(); i++) {
            rollsScoreList.add(handleNumber(singleRoleScore.charAt(i)));
        }
    }
    private Role handleNumber(Character character){
        if(isMiss.test(character))
            return new Role(0);
        return new Role(Integer.parseInt(String.valueOf(character)));
    }
}