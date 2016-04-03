package com.bitzl.open.data.distance.heatmap.generate.data;

import com.bitzl.open.data.distance.heatmap.generate.model.WeightedCoordinate;
import com.bitzl.open.data.distance.heatmap.core.model.csv.CsvRow;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@Component
public class TravelTimeImport implements CsvImport {
    @Override
    public List<WeightedCoordinate> load(String filename) {
        List<WeightedCoordinate> points = new ArrayList<>();
        Scanner scanner = new Scanner(filename);
        while (scanner.hasNextLine()) {
            CsvRow row = CsvRow.parse(scanner.nextLine());
            if (row.hasData()) {
                points.add(new WeightedCoordinate(row.latitude(), row.longitude(), row.duration()));
            }
        }
        return points;
    }
}
