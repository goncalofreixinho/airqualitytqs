package tqs.airquality.repository;
import tqs.airquality.model.AQResponse;
import org.springframework.stereotype.Repository;

@Repository
public interface cityRepository {
    AQResponse findByName(String city_name);

    void save(AQResponse city);
}

    

