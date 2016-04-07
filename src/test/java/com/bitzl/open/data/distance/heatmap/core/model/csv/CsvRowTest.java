package com.bitzl.open.data.distance.heatmap.core.model.csv;

import com.bitzl.open.data.distance.heatmap.gather.model.Detail;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

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


    @Test
    public void addShouldCreateTwoEmptyColumnsIfDetailIsNull() {
        Detail detail = null;
        row.add(detail);
        assertThat(row.toString(), is(CsvRow.SEPARATOR));
    }

    @Test
    public void parseShouldCreateCsvRow() {
        CsvRow csvRow = CsvRow.parse("a;bcd;;f");
        assertThat(csvRow.getColumns(), is(Arrays.asList("a", "bcd", "", "f")));
    }

    @Test
    public void hasDataShouldReturnTrueForRowsWithData() {
        CsvRow row = CsvRow.parse("48.590264446317505;11.773361339672915;Eichenfeld 42, 84104 Rudelzhausen, " +
                "Germany;80330.0;80.3 km;5588.0;1 hour 33 mins;OK");
        assertThat(row.hasData(), is(true));
    }


    @Test
    public void hasDataShouldReturnFalseForRowsWithoutData() {
        CsvRow row = CsvRow.parse("48.56642844440023;11.409812087886086;48.566428444400231,11.409812087886086;" +
                "ZERO_RESULTS");
        assertThat(row.hasData(), is(false));
    }

    @Test
    public void shouldReturnLatitude() {
        CsvRow row = CsvRow.parse("123.4;23.4;1.2");
        assertThat(row.latitude(), is(123.4));
    }

    @Test
    public void shouldReturnLongitude() {
        CsvRow row = CsvRow.parse("123.4;23.4;1.2");
        assertThat(row.longitude(), is(23.4));
    }

    @Test
    public void shouldReturnDuration() {
        CsvRow row = CsvRow.parse("123.4;23.4;1.2;0;0;999;");
        assertThat(row.duration(), is(999.0));
    }
}