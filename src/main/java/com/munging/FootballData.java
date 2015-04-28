package com.munging;


public class FootballData {
    int minScore;
    int maxScore;

    public FootballData(int minScore, int maxScore) {
        this.minScore = minScore;
        this.maxScore = maxScore;
    }

    public int getDifference() {
        return minScore - maxScore;
    }
}
