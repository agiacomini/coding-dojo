package com.giacomini.andrea.bowlingkata;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Arrays.asList;

public class FrameFactory {
    private static List<AFrame> frames;
    static Predicate<String> isSpare = x -> x.contains(Constants.SPARE);
    static Predicate<String> isStrike = x -> x.equals(Constants.STRIKE);
    public static List<AFrame> getFrames(String rolls){
        frames = new ArrayList<>();
        for (String singleFrame: asList(rolls.split(" "))) {
            frames.add(prepareSingleFrame(singleFrame));
        }
        return frames;
    }
    private static AFrame prepareSingleFrame(String singleFrame){
        if(isSpare.test(singleFrame) || isStrike.test(singleFrame))
            return addFrameSpareOrStrike(singleFrame);
        return new FrameNumber(singleFrame);
    }
    private static AFrame addFrameSpareOrStrike(String singleFrame){
        if(isSpare.test(singleFrame))
            return new FrameSpare(singleFrame);
        return new FrameStrike(singleFrame);
    }
}