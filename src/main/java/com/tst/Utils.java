package com.tst;

public class Utils {

    public static boolean getTruthWithChangeOfTruth(double percentChance) {
        return (Math.random() * 100) < percentChance;
    }
}
