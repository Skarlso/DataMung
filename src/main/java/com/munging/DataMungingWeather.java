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
        return super.doCompare(myTestList, new WeatherCompare());
    }

    private class WeatherCompare implements CompareBy {

        @Override
        public int returnRow() {
            return 0;
        }

        @Override
        public int minimumRow() {
            return 1;
        }

        @Override
        public int maximumRow() {
            return 2;
        }
    }
}
