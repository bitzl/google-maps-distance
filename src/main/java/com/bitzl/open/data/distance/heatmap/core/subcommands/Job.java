package com.bitzl.open.data.distance.heatmap.core.subcommands;


import com.bitzl.open.data.distance.heatmap.core.model.location.Coordinate;
import com.bitzl.open.data.distance.heatmap.core.model.location.CoordinateRange;

public class Job {
    private String apiKey;
    private Coordinate destination;
    private String file;
    private int samples;
    private CoordinateRange range;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public Coordinate getDestination() {
        return destination;
    }

    public void setDestination(Coordinate destination) {
        this.destination = destination;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public int getSamples() {
        return samples;
    }

    public void setSamples(int samples) {
        this.samples = samples;
    }

    public CoordinateRange getRange() {
        return range;
    }

    public void setRange(CoordinateRange range) {
        this.range = range;
    }

}
