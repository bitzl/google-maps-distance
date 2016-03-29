package com.bitzl.open.data.distance.heatmap.model.api;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TravelInfo {

    @SerializedName("destination_addresses")
    private List<String> destinationAddresses;
    @SerializedName("origin_addresses")
    private List<String> originAddresses;
    private List<Row> rows;

    public List<String> getDestinationAddresses() {
        return destinationAddresses;
    }

    public void setDestinationAddresses(List<String> destinationAddresses) {
        this.destinationAddresses = destinationAddresses;
    }

    public List<String> getOriginAddresses() {
        return originAddresses;
    }

    public void setOriginAddresses(List<String> originAddresses) {
        this.originAddresses = originAddresses;
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }
}
