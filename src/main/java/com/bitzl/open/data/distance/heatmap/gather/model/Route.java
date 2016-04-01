package com.bitzl.open.data.distance.heatmap.gather.model;


public class Route {

    private Detail distance;
    private Detail duration;
    private String status;

    public Detail getDistance() {
        return distance;
    }

    public void setDistance(Detail distance) {
        this.distance = distance;
    }

    public Detail getDuration() {
        return duration;
    }

    public void setDuration(Detail duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
