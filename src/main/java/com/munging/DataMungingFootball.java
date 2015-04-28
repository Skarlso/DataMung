package com.munging;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class DataMungingFootball extends Munger {

    public Stream<String> readFileLines() throws IOException {
        return super.readFileLines("football.dat");
    }

    public List<String> cleanUpStream(Stream<String> dirtyStream) throws IOException {
        return super.cleanUpStream(dirtyStream, '-');
    }

    public String doCompare(List<String> myTestList) {
        int teamNameRow = 1;
        int scoreFor = 6;
        int scoredAgainst = 7;

        String teamName = "";
        int smallest = Integer.MAX_VALUE;
        for (String line : myTestList) {
            String[] splitRow = line.split("\\s+");
            String name = splitRow[teamNameRow];
            int max = Integer.parseInt(splitRow[scoreFor]);
            int min = Integer.parseInt(splitRow[scoredAgainst]);
            if ((max - min) < smallest) {
                smallest = max - min;
                teamName = name;
            }
        }

        return teamName;

    }
}
