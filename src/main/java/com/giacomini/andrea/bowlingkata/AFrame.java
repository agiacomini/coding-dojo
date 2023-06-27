package com.giacomini.andrea.bowlingkata;

import java.util.List;

public abstract class AFrame {
    int frameScore;
    List<Role> rollsScoreList;
    void calculateFrameScore(){
        for (Role role:rollsScoreList) {
            frameScore += role.getRoleScore();
        }
    };
    int returnFrameScore(){return frameScore;};
}
