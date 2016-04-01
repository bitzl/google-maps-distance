package com.bitzl.open.data.distance.heatmap.subcommands;


import org.junit.Test;

import java.util.Arrays;

import static java.util.Collections.emptyList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CommandlineTest {

    @Test
    public void hasShouldReturnIfSubcommandIsRegistred() {
        Subcommand notRegistered = mock(Subcommand.class);
        Subcommand registered = mock(Subcommand.class);
        when(registered.getName()).thenReturn("abc");
        Commandline commandline = new Commandline(Arrays.asList(registered));
        assertThat(commandline.has(registered), is(true));
        assertThat(commandline.has(notRegistered), is(false));
    }

    @Test
    public void registerShouldAddNewSubcommand() {
        Commandline commandline = new Commandline(emptyList());
        Subcommand subcommand = mock(Subcommand.class);
        when(subcommand.getName()).thenReturn("gather");
        commandline.register(subcommand);
    }


    @Test(expected = IllegalStateException.class)
    public void registerShouldFailIfSubcommandIsAlreadyRegistered() {
        Commandline commandline = new Commandline(emptyList());
        Subcommand subcommand = mock(Subcommand.class);
        when(subcommand.getName()).thenReturn("gather");
        commandline.register(subcommand);
        commandline.register(subcommand);
    }
}