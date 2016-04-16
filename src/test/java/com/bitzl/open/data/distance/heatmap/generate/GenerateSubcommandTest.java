package com.bitzl.open.data.distance.heatmap.generate;


import com.bitzl.open.data.distance.heatmap.core.model.location.Coordinate;
import com.bitzl.open.data.distance.heatmap.core.subcommands.Job;
import com.bitzl.open.data.distance.heatmap.core.subcommands.YamlJob;
import com.bitzl.open.data.distance.heatmap.generate.data.CsvImport;
import com.bitzl.open.data.distance.heatmap.generate.model.WeightedCoordinate;
import com.bitzl.open.data.distance.heatmap.generate.service.WriterService;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GenerateSubcommandTest {

    private GenerateSubcommand subcommand;
    private String generatedFile;

    @Before
    public void setUp() throws Exception {
        CsvImport csvImport = mock(CsvImport.class);
        List<WeightedCoordinate> points = Arrays.asList(
                new WeightedCoordinate(111.0, 111.9, 11.9),
                new WeightedCoordinate(222.0, 222.9, 22.9),
                new WeightedCoordinate(333.0, 333.9, 33.9)
        );
        when(csvImport.load(any())).thenReturn(points);

        WriterService writerService = mock(WriterService.class);
        StringWriter writer = new StringWriter();
        when(writerService.createWriter()).thenReturn(writer);

        subcommand = new GenerateSubcommand(csvImport, writerService);
        Job job = mock(YamlJob.class);
        when(job.getBrowserApiKey()).thenReturn("TEST_API_KEY");
        Coordinate destination = new Coordinate(22, 33);
        when(job.getDestination()).thenReturn(destination);

        subcommand.execute(job);
        generatedFile = writer.toString();
    }

    @Test
    public void nameShouldBeGenerate() {
        assertThat(subcommand.getName(), is("generate"));
    }

    @Test
    public void generatedFileShouldContainApiKey() throws IOException {
        assertThat(generatedFile, containsString("TEST_API_KEY"));
    }

    @Test
    public void generatedFileShouldContainCoordinate() throws IOException {
        assertThat(generatedFile, containsString("center: {lat: 22.0, lng: 33.0},"));
    }

    @Test
    public void generatedFileShouldContainWeights() throws IOException {
        assertThat(generatedFile, allOf(
                containsString("{location: new google.maps.LatLng(111.0, 111.9), weight: 11.9"),
                containsString("{location: new google.maps.LatLng(222.0, 222.9), weight: 22.9"),
                containsString("{location: new google.maps.LatLng(333.0, 333.9), weight: 33.9")
        ));
    }
}