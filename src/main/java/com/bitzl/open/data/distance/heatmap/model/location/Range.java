package com.bitzl.open.data.distance.heatmap.model.location;

public class Range {

    private double min;
    private double max;

    Range() {}

    public Range(double min, double max) {
        set(min, max);
    }

    public Range(double[] values) {
        if (values.length != 2) {
            throw new IllegalArgumentException("A range can only have min and max, but array has length " + values.length);
        }
        set(values[0], values[1]);
    }

    private void set(double min, double max) {
        if (min > max) {
            throw new IllegalArgumentException("Min is larger than max.");
        }
        this.min = min;
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }
}
