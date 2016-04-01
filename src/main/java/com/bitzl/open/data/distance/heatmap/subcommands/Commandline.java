package com.bitzl.open.data.distance.heatmap.subcommands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class Commandline {

    private Map<String, Subcommand> subcommands;

    @Autowired
    public Commandline(Collection<Subcommand> subcommands) {
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
        String[] params = {};
        if (args.length > 1) {
            params = Arrays.copyOfRange(args, 1, args.length);
        }
        subcommands.get(name).execute(params);
    }
}
