package com.bitzl.open.data.distance.heatmap;


import com.bitzl.open.data.distance.heatmap.core.subcommands.Commandline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Application implements CommandLineRunner {

    private Commandline commandline;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    public Application(Commandline commandline) {
        this.commandline = commandline;
    }

    @Override
    public void run(String... args) throws Exception {
        if (args.length == 0) {
            System.out.println("Usage: java -jar distance.jar gather <jobname>.yml");
            System.out.flush();
            System.exit(1);
        }
        commandline.execute(args);
        System.out.println("Done.");
    }
}
