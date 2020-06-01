package weather.cli.api;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;

@Client("${weather.api.url}")
public interface WeatherAPIClient {
    @Get("/current?key=${weather.api.key}")
    WeatherResponse weather(@QueryValue String city,
                            @QueryValue String country);

    @Get("/forecast/daily?key=${weather.api.key}")
    ForecastResponse forecast(@QueryValue String city,
                              @QueryValue String country,
                              @QueryValue(defaultValue = "1") int days);
}
