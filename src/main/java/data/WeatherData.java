package data;

import java.sql.Timestamp;

public class WeatherData {
    private int id;
    private double windDirection;
    private double windSpeed;
    private Timestamp time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(double windDirection) {
        this.windDirection = windDirection;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Timestamp getTime() {
        return time;
    }
}
