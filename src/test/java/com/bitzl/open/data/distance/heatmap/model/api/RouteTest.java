package com.bitzl.open.data.distance.heatmap.model.api;

import com.bitzl.open.data.distance.heatmap.gather.model.Detail;
import com.bitzl.open.data.distance.heatmap.gather.model.Route;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class RouteTest {

    private Route route;

    @Before
    public void setUp() {
        route = new Route();
    }

    @Test
    public void distanceShouldBeSet() {
        Detail distance = new Detail();
        route.setDistance(distance);
        assertThat(route.getDistance(), is(distance));
    }

    @Test
    public void durationShouldBeSet() {
        Detail duration = new Detail();
        route.setDuration(duration);
        assertThat(route.getDuration(), is(duration));
    }

    @Test
    public void statusShouldBeSet() {
        String status = "adhaksdhkashdk";
        route.setStatus(status);
        assertThat(route.getStatus(), is(status));
    }
}