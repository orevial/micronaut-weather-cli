package weather.cli.api;

import io.micronaut.core.annotation.Introspected;

import java.util.List;

@Introspected
public class ForecastResponse {
    private List<ForecastObservation> data;

    public List<ForecastObservation> getData() {
        return data;
    }

    public void setData(List<ForecastObservation> data) {
        this.data = data;
    }
}
