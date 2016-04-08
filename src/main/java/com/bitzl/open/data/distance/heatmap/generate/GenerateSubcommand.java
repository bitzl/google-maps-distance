package com.bitzl.open.data.distance.heatmap.generate;

import com.bitzl.open.data.distance.heatmap.core.subcommands.Job;
import com.bitzl.open.data.distance.heatmap.core.subcommands.Subcommand;
import com.bitzl.open.data.distance.heatmap.generate.data.CsvImport;
import com.bitzl.open.data.distance.heatmap.generate.model.Context;
import com.bitzl.open.data.distance.heatmap.generate.service.WriterService;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.Writer;

/**
 * Generate a Google Maps Heatmap from the harvested data.
 */
@Component
public class GenerateSubcommand implements Subcommand {

    private CsvImport csvImport;

    private WriterService writerService;

    @Autowired
    public GenerateSubcommand(CsvImport csvImport, WriterService writerService) {
        this.csvImport = csvImport;
        this.writerService = writerService;
    }

    @Override
    public String getName() {
        return "generate";
    }

    @Override
    public void execute(Job job, String... params) throws Exception {
        try (Writer out = writerService.createWriter()) {
            MustacheFactory mustacheFactory = new DefaultMustacheFactory();
            Mustache mustache = mustacheFactory.compile("index.mustache");
            mustache.execute(out, createViewModel(job));
        }
    }

    public Context createViewModel(Job job) throws FileNotFoundException {
        Context context = new Context();
        context.setApiKey(job.getBrowserApiKey());
        context.setDestination(job.getDestination());
        context.setPoints(csvImport.load(job.getFile()));
        return context;
    }
}
