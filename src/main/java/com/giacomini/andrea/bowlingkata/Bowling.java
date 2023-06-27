package com.giacomini.andrea.bowlingkata;

import java.util.List;

public class Bowling {
    private List<AFrame> frames;
    private int scoreTotal = 0;
    public int calculateScore(String rolls){
        frames = FrameFactory.getFrames(rolls);
        calculateScoreTotal();
        return scoreTotal;
    }
    private void calculateScoreTotal(){
        for (int i = 0; i < Constants.MAX_GAMES; i++) {
            scoreTotal += frames.get(i).returnFrameScore() + calculateSingleScore(frames.get(i), i);
        }
    }
    private int calculateSingleScore(AFrame singleFrame, int index){
        if(singleFrame instanceof FrameNumber)
            return 0;
        return calculateBonus(singleFrame, index);
    }
    private int calculateBonus(AFrame singleFrame, int index){
        if(singleFrame instanceof FrameSpare)
            return calculateSpareBonusScore(index);
        return calculateStrikeBonusScore(index);
    }
    private int calculateSpareBonusScore(int index){
        if(isLastFrame(index, frames.size() -1))
            return 0;
        return frames.get(index+1).rollsScoreList.get(0).getRoleScore();

    }
    private int calculateStrikeBonusScore(int index){
        if(isLastFrame(index,frames.size() - 1))
            return 0;
        return frames.get(index+1).frameScore + frames.get(index+2).frameScore;
    }
    private boolean isLastFrame(int index, int size) {
        if(index == size)
            return true;
        return false;
    }
}