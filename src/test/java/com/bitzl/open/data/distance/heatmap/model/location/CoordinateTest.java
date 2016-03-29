package com.bitzl.open.data.distance.heatmap.model.location;


import com.bitzl.open.data.distance.heatmap.model.location.Coordinate;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
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

}
