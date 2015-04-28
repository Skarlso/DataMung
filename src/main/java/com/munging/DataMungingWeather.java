package com.munging;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class DataMungingWeather extends Munger {

    public Stream<String> readFileLines() throws IOException {
        return super.readFileLines("weather.dat");
    }

    public List<String> cleanUpStream(Stream<String> dirtyStream) throws IOException {
        return super.cleanUpStream(dirtyStream, '*');
    }

    public String doCompare(List<String> myTestList) {
        int dayRow = 1;
        int minimumTemp = 1;
        int maximumTemp = 2;

        String day = "";
        int smallest = Integer.MAX_VALUE;
        for (String line : myTestList) {
            String[] splitRow = line.split("\\s+");
            String name = splitRow[dayRow];
            int max = Integer.parseInt(splitRow[minimumTemp]);
            int min = Integer.parseInt(splitRow[maximumTemp]);
            if ((max - min) < smallest) {
                smallest = max - min;
                day = name;
            }
        }

        return day;

    }
}
