package com.bitzl.open.data.distance.heatmap.gather.service;

import com.bitzl.open.data.distance.heatmap.core.model.location.Coordinate;
import com.bitzl.open.data.distance.heatmap.gather.apis.GoogleDistanceApi;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DistanceApiServiceTest {

    private GoogleDistanceApi googleDistanceApi;

    private DistanceApiService distanceApiService;

    @Before
    public void setUp() throws Exception {
        googleDistanceApi = mock(GoogleDistanceApi.class);
        distanceApiService = new DistanceApiService(googleDistanceApi);
    }

    @Test
    public void encodeShouldEncodeOneCoordinate() throws Exception {
        assertThat(distanceApiService.encode(new Coordinate(12.3, 4.56)), is("12.3,4.56"));
    }

    @Test
    public void encodeShouldEncodeMultipleCoordinates() throws Exception {
        List<Coordinate> coordinates = asList(
                new Coordinate(1.23, 2.34),
                new Coordinate(3.33, 4.44),
                new Coordinate(7.77, 5.55)
        );
        assertThat(distanceApiService.encode(coordinates), is("1.23,2.34|3.33,4.44|7.77,5.55"));
    }

    @Test
    public void apiShouldBeCalledWithApiKey() {
        distanceApiService.query("API_KEY", asList(new Coordinate(1.1, 1.2), new Coordinate(2.1, 2.2)), new Coordinate(2.1, 2.2));
        verify(googleDistanceApi).query(matches("API_KEY"), any(), any());
    }

    @Test
    public void apiShouldBeCalledWithOriginCoordinates() {
        distanceApiService.query("API_KEY", asList(new Coordinate(1.1, 1.2), new Coordinate(2.1, 2.2)), new Coordinate(2.1, 2.2));
        verify(googleDistanceApi).query(any(), eq("1.1,1.2|2.1,2.2"), any());
    }

    @Test
    public void apiShouldBeCalledWithDestinationCoordinates() {
        distanceApiService.query("API_KEY", asList(new Coordinate(1.1, 1.2), new Coordinate(2.1, 2.2)), new Coordinate(2.1, 2.2));
        verify(googleDistanceApi).query(any(), any(String.class), eq("2.1,2.2"));
    }
}