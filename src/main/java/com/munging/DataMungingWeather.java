package com.munging;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataMungingWeather extends Munger {

    public Stream<String> readFileLines() throws IOException {
        return super.readFileLines("weather.dat");
    }

    public List<String> cleanUpStream(Stream<String> dirtyStream) throws IOException {
        return super.cleanUpStream(dirtyStream, '*');
    }

    public String doCompare(List<String> myTestList) {



        int dayRow = 0;
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

    public String doCompareWeatherData (List<WeatherData> weatherDatas) {
        String dayName = weatherDatas.stream().max(Comparator.comparing(WeatherData::getDifference)).get().dayNumber;
        return dayName;
    }

    public List<WeatherData> cleanUpStreamWeatherData(Stream<String> dirtyStream) throws IOException {
        List<WeatherData> cleanList = dirtyStream
                .map(line -> line.trim().replaceAll("\\*", ""))
                .filter(line -> line.length() > 0 && Character.isDigit(line.charAt(0)))
                .map(gatherWeatherData)
                .collect(Collectors.toList());

        return cleanList;
    }

    public Function<String, WeatherData> gatherWeatherData = line -> {
        String[] fields = line.split("\\s+");
        String day = fields[0];
        String max = fields[1];
        String min = fields[2];
        return new WeatherData(
                day,
                Integer.parseInt(min),
                Integer.parseInt(max));
    };

}
