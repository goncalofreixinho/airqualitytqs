package tqs.airquality.service;

public interface AQServiceImpl<T> {

    public T getAirQuality(String city) throws Exception;
}
