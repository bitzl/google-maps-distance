package com.bitzl.open.data.distance.heatmap.model.location;


public class CoordinateRange {

    private Range latitude;
    private Range longitude;

    public Range getLatitude() {
        return latitude;
    }

    public void setLatitude(Range latitude) {
        this.latitude = latitude;
    }

    public Range getLongitude() {
        return longitude;
    }

    public void setLongitude(Range longitude) {
        this.longitude = longitude;
    }
}
