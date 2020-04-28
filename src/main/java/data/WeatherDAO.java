package data;

import java.sql.Timestamp;
import java.util.List;

public interface WeatherDAO {
    void save(WeatherData weatherData);
    List<WeatherData> load(Timestamp start, Timestamp end);
}
