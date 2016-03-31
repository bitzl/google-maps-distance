package com.bitzl.open.data.distance.heatmap.service;

import com.bitzl.open.data.distance.heatmap.model.CsvRow;
import com.bitzl.open.data.distance.heatmap.model.api.Route;
import com.bitzl.open.data.distance.heatmap.model.api.Row;
import com.bitzl.open.data.distance.heatmap.model.api.TravelInfo;
import com.bitzl.open.data.distance.heatmap.model.location.Coordinate;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExportService {

    private static final String HEADER = "latitude;longitude;address;distance;distanceText;duration;durationText;status";

    private String createRow(Coordinate origin, String originAddress, Route route) {
        CsvRow row = new CsvRow();
        row.add(origin.getLatitude());
        row.add(origin.getLongitude());
        row.add(originAddress);
        row.add(route.getDistance());
        row.add(route.getDuration());
        row.add(route.getStatus());
        return row.toString();
    }

    private List<String> createRows(List<Coordinate> origins, TravelInfo travelInfo) {
        final int rowCount = origins.size();
        final List<String> originAdresses = travelInfo.getOriginAddresses();
        final List<Row> travelRows = travelInfo.getRows();
        List<String> rows = new ArrayList<>();
        for (int i = 0; i  < rowCount; i++) {
            rows.add(createRow(origins.get(i), originAdresses.get(i), travelRows.get(i).getRoutes().get(0)));
        }
        return rows;
    }

    public void save(Writer writer, List<Coordinate> origins, TravelInfo travelInfo) throws IOException {
        appendContent(writer, createRows(origins, travelInfo));
    }

    public void save(String filename, List<Coordinate> origins, TravelInfo travelInfo) throws IOException {
        try (FileWriter writer = new FileWriter(filename, true)) {
            if (fileIsEmpty(filename)) {
                writeHeader(writer);
            }
            appendContent(writer, createRows(origins, travelInfo));
        }
    }

    private boolean fileIsEmpty(String filename) {
        return new File(filename).length() == 0;
    }
    private void writeHeader(Writer writer) throws IOException {
        writer.write(HEADER);
        writer.write("\n");
    }

    private void appendContent(Writer writer, List<String> rows) throws IOException {
        for (String row : rows) {
            writer.write(row);
            writer.write("\n");
        }
    }
}
