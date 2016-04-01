package com.bitzl.open.data.distance.heatmap.service;

import com.bitzl.open.data.distance.heatmap.gather.apis.GoogleDistanceApi;
import com.bitzl.open.data.distance.heatmap.gather.model.TravelInfo;
import com.bitzl.open.data.distance.heatmap.model.location.Coordinate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DistanceApiService {

    private GoogleDistanceApi api;

    @Autowired
    public DistanceApiService(GoogleDistanceApi api) {
        this.api = api;
    }

    public TravelInfo query(String apiKey, List<Coordinate> origins, Coordinate destination) {
        return api.query(apiKey, encode(origins), encode(destination));
    }

    public String encode(List<Coordinate> coordinates) {
        return coordinates.stream().map(Coordinate::asString).collect(Collectors.joining("|"));
    }

    public String encode(Coordinate coordinate) {
        return coordinate.asString();
    }

}
