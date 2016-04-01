package com.bitzl.open.data.distance.heatmap.service;

import com.bitzl.open.data.distance.heatmap.gather.apis.GoogleDistanceApi;
import com.bitzl.open.data.distance.heatmap.model.location.Coordinate;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class DistanceApiServiceTest {

    private DistanceApiService distanceApiService;

    @Before
    public void setUp() throws Exception {
        GoogleDistanceApi googleDistanceApi = mock(GoogleDistanceApi.class);
        distanceApiService = new DistanceApiService(googleDistanceApi);
    }

    @Test
    public void encodeShouldEncodeOneCoordinate() throws Exception {
        assertThat(distanceApiService.encode(new Coordinate(12.3, 4.56)), is("12.3,4.56"));
    }

    @Test
    public void encodeShouldEncodeMultipleCoordinates() throws Exception {
        List<Coordinate> coordinates = Arrays.asList(
                new Coordinate(1.23, 2.34),
                new Coordinate(3.33, 4.44),
                new Coordinate(7.77, 5.55)
        );
        assertThat(distanceApiService.encode(coordinates), is("1.23,2.34|3.33,4.44|7.77,5.55"));
    }
}