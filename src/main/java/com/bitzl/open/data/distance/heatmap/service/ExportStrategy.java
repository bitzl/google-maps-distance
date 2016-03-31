package com.bitzl.open.data.distance.heatmap.service;

import com.bitzl.open.data.distance.heatmap.model.CsvRow;
import com.bitzl.open.data.distance.heatmap.model.api.Route;
import com.bitzl.open.data.distance.heatmap.model.api.Row;
import com.bitzl.open.data.distance.heatmap.model.api.TravelInfo;
import com.bitzl.open.data.distance.heatmap.model.location.Coordinate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExportStrategy {

    public String createRow(Coordinate origin, String originAddress, Route route) {
        CsvRow row = new CsvRow();
        row.add(origin.getLatitude());
        row.add(origin.getLongitude());
        row.add(originAddress);
        row.add(route.getDistance());
        row.add(route.getDuration());
        row.add(route.getStatus());
        return row.toString();
    }

    public List<String> createRows(List<Coordinate> origins, TravelInfo travelInfo) {
        final int rowCount = origins.size();
        final List<String> originAddresses = travelInfo.getOriginAddresses();
        final List<Row> travelRows = travelInfo.getRows();
        List<String> rows = new ArrayList<>();
        for (int i = 0; i  < rowCount; i++) {
            rows.add(createRow(origins.get(i), originAddresses.get(i), travelRows.get(i).getRoutes().get(0)));
        }
        return rows;
    }

}
