package weather.cli.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Spec;

import static picocli.CommandLine.Help.Visibility.ALWAYS;

public abstract class LocalizedCommand implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(ForecastSubcommand.class);

    @Spec
    protected CommandLine.Model.CommandSpec spec;

    private static final String DEFAULT_CITY = "paris";
    private static final String DEFAULT_COUNTRY_CODE = "fr";

    protected String city;
    protected String country;

    @Option(names = {"--country"},
        description = "the 2-letters country code",
        defaultValue = DEFAULT_COUNTRY_CODE,
        showDefaultValue = ALWAYS)
    public void setCountry(String country) {
        if (country.length() >= 2) {
            this.country = country.substring(0, 2).toLowerCase();
        } else {
            throw new CommandLine.ParameterException(
                spec.commandLine(),
                "Country parameter must be a 2-letters code");
        }
    }

    @Option(names = {"--city"},
        description = "the city name",
        defaultValue = DEFAULT_CITY,
        showDefaultValue = ALWAYS)
    public void setCity(String city) {
        this.city = city.toLowerCase();
    }

    @Override
    public void run() {
        LOG.info("Asking weather for city {} and country {}", city, country);
        if (DEFAULT_CITY.equals(city)) {
            LOG.warn("Using default city {}...", city);
        }
        if (DEFAULT_COUNTRY_CODE.equals(country)) {
            LOG.warn("Using default country {}...", country);
        }
    }
}
