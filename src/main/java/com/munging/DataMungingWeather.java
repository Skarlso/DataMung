package com.munging;

import java.net.URL;
import java.util.List;

public class DataMungingWeather {

    public URL readFileFromResources() {
        ClassLoader classLoader = getClass().getClassLoader();
        return classLoader.getResource("weather.dat");
    }

    public int doCompare(List<String> myTestList) {
        int returnDay = 0;
        int smallestSpread = Integer.MAX_VALUE;
        for (String line : myTestList) {
            String[] splitRow = line.split("\\s+");
            int day = Integer.parseInt(splitRow[0]);
            int maxTemp = Integer.parseInt(splitRow[1]);
            int minTemp = Integer.parseInt(splitRow[2]);
            if ((maxTemp - minTemp) < smallestSpread) {
                smallestSpread = maxTemp - minTemp;
                returnDay = day;
            }
        }

        return returnDay;
    }
}
