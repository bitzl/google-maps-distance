package com.bitzl.open.data.distance.heatmap.core.subcommands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Commandline {

    private Map<String, Subcommand> subcommands;

    private JobLoader jobLoader;

    @Autowired
    public Commandline(JobLoader jobLoader, Collection<Subcommand> subcommands) {
        this.jobLoader = jobLoader;
        this.subcommands = new HashMap<>();
        register(subcommands);
    }

    private void register(Collection<Subcommand> subcommands) {
        subcommands.forEach(this::register);
    }

    public void register(Subcommand subcommand) {
        if (has(subcommand)) {
            throw new IllegalStateException("The subcommand " + subcommand.getName() + " is already registred.");
        }
        subcommands.put(subcommand.getName(), subcommand);
    }

    public boolean has(Subcommand subcommand) {
        return subcommands.containsKey(subcommand.getName());
    }

    public void execute(String[] args) throws Exception {
        String name = args[0];
        String jobname = args[1];
        String[] params = {};
        if (args.length > 2) {
            params = Arrays.copyOfRange(args, 2, args.length);
        }
        Job job = jobLoader.loadJob(jobname);
        subcommands.get(name).execute(job, params);
    }
}
