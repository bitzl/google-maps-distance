package com.bitzl.open.data.distance.heatmap.generate.data;


import com.bitzl.open.data.distance.heatmap.generate.model.WeightedCoordinate;

import java.util.List;

public interface CsvImport {

    List<WeightedCoordinate> load(String filename);

}
