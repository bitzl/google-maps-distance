package com.bitzl.open.data.distance.heatmap.model.location;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class RangeTest {

    @Test
    public void arrayConstructorShouldTakeArraysOfLengthTwo() {
        double[] values = {1, 2};
        Range range = new Range(values);
        assertThat(range.getMin(), is(1.0));
        assertThat(range.getMax(), is(2.0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void arrayConstructorShouldNotTakeArraysOfLengthOne() {
        double[] values = {1};
        new Range(values);
    }

    @Test(expected = IllegalArgumentException.class)
    public void arrayConstructorShouldTakeArraysLongerThanTwo() {
        double[] values = {1, 2, 3};
        new Range(values);
    }

}