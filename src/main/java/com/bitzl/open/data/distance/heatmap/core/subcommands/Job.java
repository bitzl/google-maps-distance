package com.bitzl.open.data.distance.heatmap.core.subcommands;

import com.bitzl.open.data.distance.heatmap.core.model.location.Coordinate;
import com.bitzl.open.data.distance.heatmap.core.model.location.CoordinateRange;


public interface Job {
    Coordinate getDestination();

    String getFile();

    int getSamples();

    CoordinateRange getRange();

    String getServerApiKey();

    String getBrowserApiKey();
}
