package com.bitzl.open.data.distance.heatmap.gather;


import com.bitzl.open.data.distance.heatmap.gather.model.TravelInfo;
import com.bitzl.open.data.distance.heatmap.gather.service.DistanceApiService;
import com.bitzl.open.data.distance.heatmap.model.location.Coordinate;
import com.bitzl.open.data.distance.heatmap.service.ExportService;
import com.bitzl.open.data.distance.heatmap.subcommands.Job;
import com.bitzl.open.data.distance.heatmap.subcommands.Subcommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class GatherSubcommand implements Subcommand {

    private DistanceApiService distanceApiService;

    private ExportService exportService;

    @Autowired
    public GatherSubcommand(DistanceApiService distanceApiService, ExportService exportService) {
        this.distanceApiService = distanceApiService;
        this.exportService = exportService;
    }

    @Override
    public String getName() {
        return "gather";
    }

    @Override
    public void execute(Job job, String[] args) throws IOException {
        List<Coordinate> origins = Coordinate.randomSample(job.getSamples(), job.getRange());
        Coordinate destination = job.getDestination();

        TravelInfo travelInfo = distanceApiService.query(job.getApiKey(), origins, destination);
        exportService.save(job.getFile(), origins, travelInfo);
    }
}
