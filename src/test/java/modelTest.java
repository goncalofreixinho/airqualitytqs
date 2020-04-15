

import tqs.airquality.model.AQResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tqs.airquality.repository.cityRepository;

@SpringBootTest
public class modelTest {


    private cityRepository cityRepository;

    AQResponse city;

    @BeforeEach
    void beforeEach(){
        System.out.println("Start");
        city = new AQResponse("Porto", "2020-04-10 12:00:00", "34", "351", "4535");
        cityRepository.save(city);
    }

    @Test
    public void assertNotNull(){
        AQResponse city_found = cityRepository.findByName("Lisbon");
        System.out.println(city_found);
        assertThat(city_found).isNotNull();
    }

    @Test
    public void getMethods(){
        assertThat(cityRepository.findByName("Lisbon")).isEqualToComparingFieldByField(city);
    }


    @Test
    public void myTest() throws Exception {
        cityRepository.save(city);
    }

}