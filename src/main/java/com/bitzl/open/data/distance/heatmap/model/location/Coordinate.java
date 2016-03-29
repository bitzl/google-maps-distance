package com.bitzl.open.data.distance.heatmap.model.location;


import java.util.ArrayList;
import java.util.List;

public class Coordinate {

    private double latitude;
    private double longitude;

    Coordinate() {}

    public Coordinate(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String asString() {
        return latitude + "," + longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Coordinate(" + asString() + ")";
    }

    public static List<Coordinate> randomSample(int size, CoordinateRange range) {
        List<Coordinate> sample = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            sample.add(random(range));
        }
        return sample;
    }

    public static Coordinate random(CoordinateRange range) {
        double lat = random(range.getLatitude());
        double lon = random(range.getLongitude());
        return new Coordinate(lat, lon);
    }

    private static double random(Range range) {
        return range.getMin() + Math.random() * (range.getMax() - range.getMin());
    }
}
