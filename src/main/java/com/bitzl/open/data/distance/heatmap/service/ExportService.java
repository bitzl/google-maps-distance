package com.bitzl.open.data.distance.heatmap.service;

import com.bitzl.open.data.distance.heatmap.model.location.Coordinate;
import com.bitzl.open.data.distance.heatmap.model.CsvRow;
import com.bitzl.open.data.distance.heatmap.model.api.Element;
import com.bitzl.open.data.distance.heatmap.model.api.Row;
import com.bitzl.open.data.distance.heatmap.model.api.TravelInfo;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExportService {

    private static final String HEADER = "latitude;longitude;address;distance;distanceText;duration;durationText;status";

    String createRow(Coordinate origin, String originAddress, Element element) {
        CsvRow row = new CsvRow();
        row.add(origin.getLatitude());
        row.add(origin.getLongitude());
        row.add(originAddress);
        row.add(element.getDistance());
        row.add(element.getDuration());
        row.add(element.getStatus());
        return row.toString();
    }

    List<String> createRows(List<Coordinate> origins, TravelInfo travelInfo) {
        final int rowCount = origins.size();
        final List<String> originAdresses = travelInfo.getOriginAddresses();
        final List<Row> travelRows = travelInfo.getRows();
        List<String> rows = new ArrayList<>();
        for (int i = 0; i  < rowCount; i++) {
            rows.add(createRow(origins.get(0), originAdresses.get(0), travelRows.get(0).getElements().get(0)));
        }
        return rows;
    }

    public void save(String filename, List<Coordinate> origins, TravelInfo travelInfo) {
        File file = new File(filename);
        if (!file.exists()) {
            writeHeader(file);
        }
        appendContent(file, createRows(origins, travelInfo));
    }

    private void writeHeader(File file) {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(HEADER);
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void appendContent(File file, List<String> rows) {
        try (FileWriter writer = new FileWriter(file, true)) {
            for (String row : rows) {
                writer.write(row);
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
