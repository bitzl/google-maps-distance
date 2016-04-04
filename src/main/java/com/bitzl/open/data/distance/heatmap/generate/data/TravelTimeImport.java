package com.bitzl.open.data.distance.heatmap.generate.data;

import com.bitzl.open.data.distance.heatmap.core.model.csv.CsvRow;
import com.bitzl.open.data.distance.heatmap.generate.model.WeightedCoordinate;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@Component
public class TravelTimeImport implements CsvImport {
    @Override
    public List<WeightedCoordinate> load(String filename) throws FileNotFoundException {
        List<WeightedCoordinate> points = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                CsvRow row = CsvRow.parse(scanner.nextLine());
                if (row.hasData()) {
                    points.add(new WeightedCoordinate(row.latitude(), row.longitude(), row.duration()));
                }
            }
        }
        return points;
    }
}
