package com.bitzl.open.data.distance.heatmap.generate.service;

import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

@Service
public class WriterService {

    public Writer createWriter() throws IOException {
        return new FileWriter("test.html");
    }
}
