package com.munging;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DataMungingWeather {

    public List<String> readFileFromResources() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL fileURI = classLoader.getResource("weather.dat");
        return Files.readAllLines(Paths.get(fileURI.getFile()));
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
