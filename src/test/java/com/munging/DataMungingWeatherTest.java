package com.munging;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;

public class DataMungingWeatherTest {

    private DataMungingWeather dataMungingWeather;

    @Before
    public void setUp() throws Exception {
        dataMungingWeather = new DataMungingWeather();
    }

    @Test
    public void testCanReadFileFromResources() throws Exception {
        Assert.assertThat(dataMungingWeather.readFileFromResources(), is(not(nullValue())));

    }
}