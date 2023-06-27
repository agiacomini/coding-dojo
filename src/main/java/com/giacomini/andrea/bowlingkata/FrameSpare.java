package com.giacomini.andrea.bowlingkata;

import java.util.ArrayList;

public class FrameSpare extends AFrame{
    public FrameSpare(String frameRolls) {
        rollsScoreList = new ArrayList<>(Constants.MAX_ROLLS_IN_FRAME);
        handleScore(frameRolls);
        calculateFrameScore();
    }
    private void handleScore(String singleRoleScore) {
        for (int i = 0; i < singleRoleScore.length(); i++) {
            rollsScoreList.add(handleSpare(singleRoleScore.charAt(i)));
        }
    }
    private Role handleSpare(Character punteggio){
        if(Character.isDigit(punteggio))
            return new Role(Integer.parseInt(String.valueOf(punteggio)));
        return new Role(10 - rollsScoreList.get(0).getRoleScore());
    }
}