package weather.cli.api;

import java.util.List;

public class ForecastResponse {
    private List<ForecastObservation> data;

    public List<ForecastObservation> getData() {
        return data;
    }

    public void setData(List<ForecastObservation> data) {
        this.data = data;
    }
}
