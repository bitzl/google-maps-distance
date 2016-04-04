package com.bitzl.open.data.distance.heatmap.generate.model;


import com.bitzl.open.data.distance.heatmap.core.model.location.Coordinate;

import java.util.List;

public class Context {

    private Coordinate destination;

    private List<WeightedCoordinate> points;

    private String apiKey;

    public Coordinate getDestination() {
        return destination;
    }

    public void setDestination(Coordinate destination) {
        this.destination = destination;
    }

    public List<WeightedCoordinate> getPoints() {
        return points;
    }

    public void setPoints(List<WeightedCoordinate> points) {
        this.points = points;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
