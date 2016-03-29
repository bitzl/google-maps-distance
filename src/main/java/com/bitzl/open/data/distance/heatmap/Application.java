package com.bitzl.open.data.distance.heatmap;


import com.bitzl.open.data.distance.heatmap.model.location.Coordinate;
import com.bitzl.open.data.distance.heatmap.model.api.TravelInfo;
import com.bitzl.open.data.distance.heatmap.model.config.Job;
import com.bitzl.open.data.distance.heatmap.service.DistanceApiService;
import com.bitzl.open.data.distance.heatmap.service.ExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.util.List;

@ComponentScan
public class Application implements CommandLineRunner {

    @Autowired
    private DistanceApiService distanceApiService;

    @Autowired
    private ExportService exportService;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: java -jar distance.jar <jobname>.yml");
            System.exit(1);
        }

        Job job = new Yaml().loadAs(new FileInputStream(args[0]), Job.class);

        List<Coordinate> origins = Coordinate.randomSample(job.getSamples(), job.getRange());
        Coordinate destination = job.getDestination();

        TravelInfo travelInfo = distanceApiService.query(job.getApiKey(), origins, destination);
        exportService.save(job.getFile(), origins, travelInfo);

    }
}
