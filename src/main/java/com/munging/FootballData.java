package com.munging;


public class FootballData implements Data {
    String teamName;
    int minScore;
    int maxScore;

    public FootballData(String teamName, int minScore, int maxScore) {
        this.teamName = teamName;
        this.minScore = minScore;
        this.maxScore = maxScore;
    }

    public int getDifference() {
        return maxScore - minScore;
    }
}
