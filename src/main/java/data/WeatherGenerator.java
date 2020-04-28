package data;

import java.sql.Timestamp;

public class WeatherGenerator implements WeatherObservable {
    private WeatherListener listener;

    @Override
    public void run() {
        while (true){
            if (listener !=null) {
                Timestamp now = new Timestamp(System.currentTimeMillis());
                double windSpeed = Math.random() * 30;
                double windDirection = Math.random() * 360;
                WeatherData weatherData = new WeatherData();
                weatherData.setTime(now);
                weatherData.setWindDirection(windDirection);
                weatherData.setWindSpeed(windSpeed);
                this.listener.notify(weatherData);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void register(WeatherListener listener) {
        this.listener = listener;
    }
}
