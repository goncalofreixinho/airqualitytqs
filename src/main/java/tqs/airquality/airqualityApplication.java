package tqs.airquality;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class airqualityApplication {

    public static void main(String[] args) {
        SpringApplication.run(airqualityApplication.class, args);
    }

}
