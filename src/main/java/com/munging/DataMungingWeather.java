package com.munging;

import java.net.URL;

public class DataMungingWeather {

    public URL readFileFromResources() {
        ClassLoader classLoader = getClass().getClassLoader();
        return classLoader.getResource("weather.dat");
    }
}
