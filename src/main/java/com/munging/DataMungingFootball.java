package com.munging;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataMungingFootball {

    public Stream<String> readFileLines() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL fileUrl = classLoader.getResource("football.dat");
        assert fileUrl != null;
        Stream<String> dirtyStream = Files.lines(Paths.get(fileUrl.getFile()));
        return dirtyStream;
    }

    public List<String> cleanUpStream(Stream<String> dirtyStream) throws IOException {
        List<String> cleanList = dirtyStream
                .map(line -> line.trim().replaceAll("\\-", ""))
                .filter(line -> line.length() > 0 && Character.isDigit(line.charAt(0)))
                .collect(Collectors.toList());
        return cleanList;
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
