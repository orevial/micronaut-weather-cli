package weather.cli.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import picocli.CommandLine.Command;
import weather.cli.api.WeatherAPIClient;
import weather.cli.api.WeatherResponse;

import javax.inject.Inject;

@Command(name = "weather", description = "gives weather for a given location")
public class CurrentWeatherSubcommand extends LocalizedCommand {
    private static final Logger LOG = LoggerFactory.getLogger(CurrentWeatherSubcommand.class);

    @Inject
    public WeatherAPIClient weatherAPIClient;

    @Override
    public void run() {
        super.run();

        WeatherResponse weather = weatherAPIClient.weather(city, country);
        LOG.info("=====================================");
        LOG.info("Current weather in {}: \n{}", city, weather.getData().get(0).toString());
        LOG.info("=====================================");
    }
}
