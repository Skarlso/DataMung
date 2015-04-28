package com.munging;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;

public class DataMungingFootballTest {

    private DataMungingFootball dataMungingFootball;

    @Before
    public void setUp() throws Exception {
        dataMungingFootball = new DataMungingFootball();
    }

    @Test
    public void testCanReadFileFromResources() throws Exception {
        Assert.assertThat(dataMungingFootball.cleanUpStream(dataMungingFootball.readFileLines()), is(not(nullValue())));
    }

    @Test
    public void testCanCompareAListOfSpacedNumbers() throws Exception {
        List<String> myTestList = Arrays.asList(
                "1. Arsenal         38    26   9   3    79    36    87",
                "2. Liverpool       38    24   8   6    67    30    80");
        Assert.assertThat(dataMungingFootball.doCompare(myTestList), is("Liverpool"));
    }

    @Test
    public void testCanReadAllTheLinesFromFile() throws Exception {
        Assert.assertThat(dataMungingFootball.cleanUpStream(dataMungingFootball.readFileLines()).isEmpty(), is(false));
    }

    @Test
    public void testCanCompareTheLinesReadFromTheFile() throws Exception {
        Assert.assertThat(dataMungingFootball.doCompare(
                dataMungingFootball.cleanUpStream(
                        dataMungingFootball.readFileLines())), is("Leicester"));
    }

    @Test
    public void testCanCleanUpAListOfStrings() throws Exception {
        List<String> myTestList = Arrays.asList("1 44- 33", "2 99 98", "a f b d e", "1- 23 44");
        Assert.assertThat(dataMungingFootball.cleanUpStream(myTestList.stream()), is(Arrays.asList("1 44 33", "2 99 98", "1 23 44")));
    }

}