package edu.sjsu.cs185c.here;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

public class Main {

    @Command(name = "hello", mixinStandardHelpOptions = true, description = "register attendance for class.")
    static class Cli implements Callable<Integer> {
        @Parameters(index = "0", description = "server:port to connect to.")
        String serverPort;

        @Override
        public Integer call() throws Exception {
            System.out.printf("will contact %s\n", serverPort);
            return 0;
        }
    }
    public static void main(String[] args) {
        System.exit(new CommandLine(new Cli()).execute(args));
    }
}
