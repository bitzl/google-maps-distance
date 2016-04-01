package com.bitzl.open.data.distance.heatmap.subcommands;


/**
 * A subcommand to expose subsystems on the command line.
 */
public interface Subcommand {

    /**
     * @return How this subcommand is called on command line.
     */
    String getName();

    /**
     * Execute this subcommand.
     * @param params The command line parameter.
     */
    void execute(String... params);

}
