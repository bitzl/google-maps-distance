package com.bitzl.open.data.distance.heatmap.model.api;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class DetailTest {

    private Detail detail;

    @Before
    public void setUp() throws Exception {
        detail = new Detail();
    }

    @Test
    public void textShouldBeSet() {
        detail.setText("asdfgh");
        assertThat(detail.getText(), is("asdfgh"));
    }

    @Test
    public void valueShouldBeSet() {
        detail.setValue(123123L);
        assertThat(detail.getValue(), is(123123L));
    }

}