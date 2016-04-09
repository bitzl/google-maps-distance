package com.bitzl.open.data.distance.heatmap.gather;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class GatherSubcommandTest {

    @Test
    public void nameShouldBeGather() throws Exception {
        GatherSubcommand subcommand = new GatherSubcommand(null, null);
        assertThat(subcommand.getName(), is("gather"));
    }

}