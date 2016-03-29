package com.bitzl.open.data.distance.heatmap.model;


import com.bitzl.open.data.distance.heatmap.model.api.Detail;

import java.util.ArrayList;
import java.util.List;

public class CsvRow {

    private List<String> columns;

    private static final String  SEPARATOR = ";";

    public CsvRow() {
        this.columns = new ArrayList<>();
    }

    public void add(String column) {
        this.columns.add(column);
    }

    public void add(double colum) {
        add(Double.toString(colum));
    }

    public void add(Detail detail) {
        if (detail == null) {
            add(""); // Add empty column
            add(""); // Add empty column
            return;
        }
        add(detail.getValue());
        add(detail.getText());
    }

    public String toString() {
        return String.join(SEPARATOR, columns);
    }
}
