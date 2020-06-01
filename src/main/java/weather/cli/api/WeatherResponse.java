package weather.cli.api;

import io.micronaut.core.annotation.Introspected;

import java.util.List;

@Introspected
public class WeatherResponse {
    private List<WeatherObservation> data;
    private int count;

    public List<WeatherObservation> getData() {
        return data;
    }

    public void setData(List<WeatherObservation> data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
