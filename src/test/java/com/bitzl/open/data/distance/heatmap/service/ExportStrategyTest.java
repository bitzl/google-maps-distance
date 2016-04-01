package com.bitzl.open.data.distance.heatmap.service;

import com.bitzl.open.data.distance.heatmap.gather.model.Detail;
import com.bitzl.open.data.distance.heatmap.gather.model.Route;
import com.bitzl.open.data.distance.heatmap.model.location.Coordinate;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class ExportStrategyTest {

    @Test
    public void shouldCreateValidCsvRow() {
        ExportStrategy exportStrategy = new ExportStrategy();
        Coordinate origin = new Coordinate(12.3,45.6);
        String originAddress = "Munich";
        Route route = new Route();
        route.setDistance(new Detail("123 km", 123L));
        route.setDuration(new Detail("12 h", 333L));
        route.setStatus("OK");
        assertThat(exportStrategy.createRow(origin, originAddress, route),
                is("12.3;45.6;Munich;123.0;123 km;333.0;12 h;OK"));
    }

}