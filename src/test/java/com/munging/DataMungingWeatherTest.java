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
        Assert.assertThat(dataMungingWeather.cleanUpStream(dataMungingWeather.readFileLines()), is(not(nullValue())));
    }

    @Test
    public void testCanCompareAListOfSpacedNumbers() throws Exception {
        List<String> myTestList = Arrays.asList("1 44 33", "2 99 98");
        Assert.assertThat(dataMungingWeather.doCompare(myTestList), is("2"));
    }

    @Test
    public void testCanReadAllTheLinesFromFile() throws Exception {
        Assert.assertThat(dataMungingWeather.cleanUpStream(dataMungingWeather.readFileLines()).isEmpty(), is(false));
    }

    @Test
    public void testCanCompareTheLinesReadFromTheFile() throws Exception {
        Assert.assertThat(dataMungingWeather.doCompare(
                dataMungingWeather.cleanUpStream(
                        dataMungingWeather.readFileLines())), is("14"));
    }

    @Test
    public void testCanCleanUpAListOfStrings() throws Exception {
        List<String> myTestList = Arrays.asList("1 44* 33", "2 99 98", "a f b d e", "1* 23 44");
        Assert.assertThat(dataMungingWeather.cleanUpStream(myTestList.stream()), is(Arrays.asList("1 44 33", "2 99 98", "1 23 44")));
    }
}