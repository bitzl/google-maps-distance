package com.bitzl.open.data.distance.heatmap.model;


import com.bitzl.open.data.distance.heatmap.gather.model.Detail;

import java.util.ArrayList;
import java.util.List;

public class CsvRow {

    private List<String> columns;

    public static final String SEPARATOR = ";";

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
            emptyColumn();
            emptyColumn();
            return;
        }
        add(detail.getValue());
        add(detail.getText());
    }

    public void emptyColumn() {
        add("");
    }

    public String toString() {
        return String.join(SEPARATOR, columns);
    }

    public static CsvRow parse(String line) {
        CsvRow csvRow = new CsvRow();
        for (String column : line.split(SEPARATOR)) {
            csvRow.add(column);
        }
        return csvRow;
    }

    public List<String> getColumns() {
        return columns;
    }
}
