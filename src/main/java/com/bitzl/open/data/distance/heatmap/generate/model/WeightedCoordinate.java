package com.bitzl.open.data.distance.heatmap.generate.model;

import com.bitzl.open.data.distance.heatmap.core.model.location.Coordinate;


public class WeightedCoordinate extends Coordinate {

    private double weight;

    public WeightedCoordinate(double latitude, double longitude, double weight) {
        super(latitude, longitude);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}
