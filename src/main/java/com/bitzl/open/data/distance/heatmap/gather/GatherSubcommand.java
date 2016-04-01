package com.bitzl.open.data.distance.heatmap.gather;


import com.bitzl.open.data.distance.heatmap.gather.model.TravelInfo;
import com.bitzl.open.data.distance.heatmap.model.config.Job;
import com.bitzl.open.data.distance.heatmap.model.location.Coordinate;
import com.bitzl.open.data.distance.heatmap.gather.service.DistanceApiService;
import com.bitzl.open.data.distance.heatmap.service.ExportService;
import com.bitzl.open.data.distance.heatmap.subcommands.Subcommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
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
    public void execute(String... params) throws IOException {
        if (params.length != 1) {
            throw new IllegalArgumentException("There must be only one argument: The name of the jobfile.");
        }
        Job job = new Yaml().loadAs(new FileInputStream(params[0]), Job.class);

        List<Coordinate> origins = Coordinate.randomSample(job.getSamples(), job.getRange());
        Coordinate destination = job.getDestination();

        TravelInfo travelInfo = distanceApiService.query(job.getApiKey(), origins, destination);
        exportService.save(job.getFile(), origins, travelInfo);
    }
}
