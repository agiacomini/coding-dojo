package com.giacomini.andrea.bowlingkata;

import java.util.ArrayList;

public class FrameStrike extends AFrame{
    public FrameStrike(String frameRolls){
        rollsScoreList = new ArrayList<>(Constants.MAX_ROLLS_IN_FRAME);
        handleScore(frameRolls);
        calculateFrameScore();
    }
    private void handleScore(String singleRoleScore) {
        rollsScoreList.add(new Role(10));
    }
}