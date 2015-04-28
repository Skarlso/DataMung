package com.munging;

import java.net.URL;
import java.util.List;

public class DataMungingWeather {

    public URL readFileFromResources() {
        ClassLoader classLoader = getClass().getClassLoader();
        return classLoader.getResource("weather.dat");
    }

    public int doCompare(List<String> myTestList) {
        return 0;
    }
}
