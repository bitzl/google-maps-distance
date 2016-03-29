package com.bitzl.open.data.distance.heatmap.model.location;


import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class CoordinateTest {

    @Test
    public void toStringShouldReturnStringRepresentation() {
        Coordinate coordinate = new Coordinate(12.3, 3.45);
        assertThat(coordinate.toString(), is("Coordinate(12.3,3.45)"));
    }

    @Test
    public void asStringShouldReturnStringRepresentation() {
        Coordinate coordinate = new Coordinate(12.3, 3.45);
        assertThat(coordinate.asString(), is("12.3,3.45"));
    }

    @Test
    public void randomSampleShouldReturnDifferentValues() {
        CoordinateRange range = new CoordinateRange(new Range(1, 5), new Range(3, 7));
        List<Coordinate> sample = Coordinate.randomSample(2, range);
        assertThat(sample.get(0).asString(), is(not(sample.get(1).asString())));
    }
}
