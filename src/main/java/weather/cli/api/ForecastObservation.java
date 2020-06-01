package weather.cli.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

@Introspected
public class ForecastObservation {
    private String forecastDate;
    private double windSpeed;
    private double avgTemparature;
    private double minTemperature;
    private double maxTemperature;
    private double precipitationPropability;
    private double avgCloudCoverage;

    public String getForecastDate() {
        return forecastDate;
    }

    @JsonProperty("valid_date")
    public void setForecastDate(String forecastDate) {
        this.forecastDate = forecastDate;
    }

    @JsonProperty("wind_spd")
    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed * 3.6;
    }

    @JsonProperty("temp")
    public void setAvgTemparature(double avgTemparature) {
        this.avgTemparature = avgTemparature;
    }

    @JsonProperty("min_temp")
    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    @JsonProperty("max_temp")
    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    @JsonProperty("pop")
    public void setPrecipitationPropability(double precipitationPropability) {
        this.precipitationPropability = precipitationPropability;
    }

    @JsonProperty("clouds")
    public void setAvgCloudCoverage(double avgCloudCoverage) {
        this.avgCloudCoverage = avgCloudCoverage;
    }

    @Override
    public String toString() {
        return "  - average temperature: " + avgTemparature + "°C" +
                "\n  - min temperature: " + minTemperature + "°C" +
                "\n  - max temperature: " + maxTemperature + "°C" +
                "\n  - wind speed: " + windSpeed + " km/h" +
                "\n  - probability of precipitation: " + precipitationPropability + "%" +
                "\n  - average cloud coverage: " + avgCloudCoverage + "%";
    }
}
