package weather.cli;

import io.micronaut.configuration.picocli.PicocliRunner;
import picocli.CommandLine.Command;
import weather.cli.commands.CurrentWeatherSubcommand;
import weather.cli.commands.ForecastSubcommand;

@Command(subcommands = {
    CurrentWeatherSubcommand.class,
    ForecastSubcommand.class
})
public class WeatherCliCommand implements Runnable {

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(WeatherCliCommand.class, args);
    }

    public void run() {
        System.out.println("Welcome to weather app...");
    }
}