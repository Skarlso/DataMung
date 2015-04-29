package com.munging;

public class WeatherData {
    String dayNumber;
    int minimumTemp;
    int maximumTemp;

    public WeatherData (String dayNumber, int minimumTemp, int maximumTemp) {
        this.dayNumber = dayNumber;
        this.minimumTemp = minimumTemp;
        this.maximumTemp = maximumTemp;
    }

    public int getDifference() {
        return minimumTemp - maximumTemp;
    }
}
