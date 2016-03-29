package com.bitzl.open.data.distance.heatmap.model;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class CsvRowTest {

    private CsvRow row;
    @Before
    public void setUp() throws Exception {
        row = new CsvRow();
    }

    @Test
    public void emptyColumnShouldCreateNewColumn() {
        row.emptyColumn();
        assertThat(row.toString(), is(CsvRow.SEPARATOR));
    }

}