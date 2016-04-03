package com.bitzl.open.data.distance.heatmap.core.subcommands;


import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Loads job files.
 */
@Component
public class JobLoader {

    public Job loadJob(String filename) throws FileNotFoundException {
        return new Yaml().loadAs(new FileInputStream(filename), Job.class);
    }

}
