package data;

public interface WeatherObservable extends Runnable {
    void register(WeatherListener listener);
}
