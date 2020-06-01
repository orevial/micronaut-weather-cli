package weather.cli.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import weather.cli.api.ForecastObservation;
import weather.cli.api.ForecastResponse;
import weather.cli.api.WeatherAPIClient;

import javax.inject.Inject;

import static java.util.Comparator.comparing;
import static picocli.CommandLine.Help.Visibility.ALWAYS;

@Command(name = "forecast", description = "gives forecast for given city")
public class ForecastSubcommand extends LocalizedCommand {
    private static final Logger LOG = LoggerFactory.getLogger(ForecastSubcommand.class);

    private int nbDays;

    @Inject
    public WeatherAPIClient weatherAPIClient;

    @Option(names = {"-d", "--days"},
        description = "the number of forecast days to fetch (between 1 and 16)",
        defaultValue = "1",
        showDefaultValue = ALWAYS)
    public void setNbDays(int nbDays) {
        if (nbDays < 1 || nbDays > 16) {
            throw new CommandLine.ParameterException(
                spec.commandLine(),
                "Forecast must be between 1 and 16 days");
        }
        this.nbDays = nbDays;
    }

    @Override
    public void run() {
        super.run();

        ForecastResponse forecast = weatherAPIClient.forecast(city, country, nbDays);
        LOG.info("=====================================");
        forecast.getData().stream()
            .sorted(comparing(ForecastObservation::getForecastDate))
            .forEach(forecastObservation -> LOG.info("Forecast in {} on day {}: \n{}",
                city, forecastObservation.getForecastDate(),
                forecastObservation.toString()));
        LOG.info("=====================================");
    }
}
