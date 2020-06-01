package weather.cli.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

public class WeatherObservation {
    private double windSpeed;
    private double temperature;
    private double cloudCoverage;
    private double precipitation;

    @JsonProperty("wind_spd")
    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed * 3.6;
    }

    @JsonProperty("temp")
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @JsonProperty("clouds")
    public void setCloudCoverage(double cloudCoverage) {
        this.cloudCoverage = cloudCoverage;
    }

    @JsonProperty("precip")
    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }

    @Override
    public String toString() {
        return "  - temperature: " + temperature + "°C" +
                "\n  - wind speed: " + windSpeed + " km/h" +
                "\n  - cloud coverage: " + cloudCoverage + "%" +
                "\n  - precipitation: " + precipitation + " mm/h";
    }
}
