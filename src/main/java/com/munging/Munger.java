package com.munging;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Munger {


    public Stream<String> readFileLines(String filename) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL fileUrl = classLoader.getResource(filename);
        assert fileUrl != null;
        Stream<String> dirtyStream = Files.lines(Paths.get(fileUrl.getFile()));
        return dirtyStream;
    }

    public List<String> cleanUpStream(Stream<String> dirtyStream, Character character) throws IOException {
        List<String> cleanList = dirtyStream
                .map(line -> line.trim().replaceAll(String.format("\\%s", character), ""))
                .filter(line -> line.length() > 0 && Character.isDigit(line.charAt(0)))
                .collect(Collectors.toList());
        return cleanList;
    }

    public String doCompare(List<String> myTestList, CompareBy compareBy) {
        String returnDay = "";
        int smallest = Integer.MAX_VALUE;
        for (String line : myTestList) {
            String[] splitRow = line.split("\\s+");
            String day = splitRow[compareBy.returnRow()];
            int max = Integer.parseInt(splitRow[compareBy.minimumRow()]);
            int min = Integer.parseInt(splitRow[compareBy.maximumRow()]);
            if ((max - min) < smallest) {
                smallest = max - min;
                returnDay = day;
            }
        }

        return returnDay;
    }
}
