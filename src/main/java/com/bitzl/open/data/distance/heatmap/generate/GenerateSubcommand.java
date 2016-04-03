package com.bitzl.open.data.distance.heatmap.generate;

import com.bitzl.open.data.distance.heatmap.generate.data.CsvImport;
import com.bitzl.open.data.distance.heatmap.generate.model.Context;
import com.bitzl.open.data.distance.heatmap.core.subcommands.Job;
import com.bitzl.open.data.distance.heatmap.core.subcommands.Subcommand;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.Writer;

/**
 * Generate a Google Maps Heatmap from the harvested data.
 */
@Component
public class GenerateSubcommand implements Subcommand {

    private CsvImport csvImport;

    @Autowired
    public GenerateSubcommand(CsvImport csvImport) {
        this.csvImport = csvImport;
    }

    @Override
    public String getName() {
        return "generate";
    }

    @Override
    public void execute(Job job, String... params) throws Exception {
        try (Writer out = new FileWriter("test.html")) {
            MustacheFactory mustacheFactory = new DefaultMustacheFactory();
            Mustache mustache = mustacheFactory.compile("index.mustache");
            mustache.execute(out, createViewModel(job));
        }
    }

    private Context createViewModel(Job job) {
        Context context = new Context();
        context.setApiKey(job.getApiKey());
        context.setDestination(job.getDestination());
        context.setPoints(csvImport.load(job.getFile()));
        return context;
    }
}
