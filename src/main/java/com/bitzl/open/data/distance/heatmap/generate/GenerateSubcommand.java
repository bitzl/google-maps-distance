package com.bitzl.open.data.distance.heatmap.generate;

import com.bitzl.open.data.distance.heatmap.subcommands.Job;
import com.bitzl.open.data.distance.heatmap.subcommands.Subcommand;
import org.springframework.stereotype.Component;

/**
 * Generate a Google Maps Heatmap from the harvested data.
 */
@Component
public class GenerateSubcommand implements Subcommand {

    @Override
    public String getName() {
        return "generate";
    }

    @Override
    public void execute(Job job, String... params) throws Exception {
        System.out.println("Not implemented.");
    }
}
