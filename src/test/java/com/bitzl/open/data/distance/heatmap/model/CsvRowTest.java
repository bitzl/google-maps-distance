package com.bitzl.open.data.distance.heatmap.model;

import com.bitzl.open.data.distance.heatmap.model.api.Detail;
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
        row.add("X");
        assertThat(row.toString(), is(CsvRow.SEPARATOR + "X"));
    }

    @Test
    public void addDetailShouldAddTextAndValue() {
        Detail detail = new Detail();
        detail.setValue(12L);
        detail.setText("ABC");
        row.add(detail);
        assertThat(row.toString(), is("12.0" + CsvRow.SEPARATOR + "ABC"));
    }

}