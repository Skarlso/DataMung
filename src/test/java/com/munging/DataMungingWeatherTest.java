package com.munging;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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

    @Test
    public void testCanCompareAListOfSpacedNumbers() throws Exception {
        List<String> myTestList = Arrays.asList("1 44 33", "2 99 98");
        Assert.assertThat(dataMungingWeather.doCompare(myTestList), is(2));
    }
}