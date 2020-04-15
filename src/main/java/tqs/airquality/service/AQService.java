package tqs.airquality.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import tqs.airquality.model.AQResponse;

import javax.annotation.PostConstruct;

@Service
public class AQService implements AQServiceImpl<AQResponse> {

    private UriComponentsBuilder urlb;

    @PostConstruct
    protected void init() {

        urlb = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("api.weatherbit.io/")
                .path("/v2.0/current/airquality")
                .queryParam("city", "Porto")
                .queryParam("key", "b0d5e530de114586a754b6c4e97de891");
    }


    @Override
    @Cacheable("city_airquality")
    public AQResponse getAirQuality(String city_name) {
        String url = urlb.replaceQueryParam("city", city_name).build().toUriString();
        return new RestTemplate().getForObject(url, AQResponse.class);
    }
}