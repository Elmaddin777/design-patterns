package observer;

import java.util.ArrayList;
import java.util.List;

interface ChannelObserver {

    void update(float temperature);

}

interface WeatherForecastSubject {

    void registerObserver(ChannelObserver channelObserver);
    void removeObserver(ChannelObserver channelObserver);
    void notifyObservers();

}

class WeatherStation implements WeatherForecastSubject {

    private final List<ChannelObserver> channelObservers = new ArrayList<>();
    private float temperature;

    @Override
    public void registerObserver(ChannelObserver channelObserver) {
        this.channelObservers.add(channelObserver);
    }

    @Override
    public void removeObserver(ChannelObserver channelObserver) {
        this.channelObservers.remove(channelObserver);
    }

    @Override
    public void notifyObservers() {
        channelObservers.forEach(o -> o.update(this.temperature));
    }

    public void setTemperature(float temperature) {
        System.out.println("Temperature is set to " + temperature + " in the weather station");
        this.temperature = temperature;
        notifyObservers();
    }

}

class PhoneDisplay implements ChannelObserver {

    private float temperature;

    @Override
    public void update(float temperature) {
        this.temperature = temperature;
    }

    public float displayTemperature() {
        return this.temperature;
    }

}

class WindDisplay implements ChannelObserver {

    private float temperature;

    @Override
    public void update(float temperature) {
        this.temperature = temperature;
    }

    public float displayTemperature() {
        return this.temperature;
    }

}

class WeatherForecastingDemo {

    public static void main(String[] args) {
        // Create observers
        var phoneDisplay = new PhoneDisplay();
        var windowDisplay = new WindDisplay();

        // Create the subject and set temperature
        var weatherStation = new WeatherStation();
        weatherStation.registerObserver(phoneDisplay);
        weatherStation.registerObserver(windowDisplay);
        weatherStation.setTemperature(10); // Observers also notified

        // Display the temperature
        System.out.println("Temperature from phone display: " + phoneDisplay.displayTemperature());
        System.out.println("Temperature from window display: " + windowDisplay.displayTemperature());
    }

}
