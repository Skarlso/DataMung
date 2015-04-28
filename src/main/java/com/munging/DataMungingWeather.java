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
        return super.doCompare(myTestList, 0, 1, 2);
    }
}
