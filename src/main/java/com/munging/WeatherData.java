package com.munging;

public class WeatherData {
    int minimumTemp;
    int maximumTemp;

    public WeatherData (int minimumTemp, int maximumTemp) {

        this.minimumTemp = minimumTemp;
        this.maximumTemp = maximumTemp;
    }

    public int getDifference() {
        return minimumTemp - maximumTemp;
    }
}
