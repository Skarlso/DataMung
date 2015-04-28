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
        return super.doCompare(myTestList, new FootballCompare());
    }

    private class FootballCompare implements CompareBy {

        @Override
        public int returnRow() {
            return 1;
        }

        @Override
        public int minimumRow() {
            return 6;
        }

        @Override
        public int maximumRow() {
            return 7;
        }
    }
}
