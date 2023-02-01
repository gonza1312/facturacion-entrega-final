package com.example.facturacionentregaproyectofinalroldan.clients;

import com.example.facturacionentregaproyectofinalroldan.entities.WorldClock;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WorldClockClient {

    RestTemplate restTemplate = new RestTemplate();
    String fooResourceUrl = "http://worldclockapi.com/api/json/utc/now";

    public WorldClock obtenerDateCurrentTime() {
        try {
            return restTemplate.getForObject(fooResourceUrl, WorldClock.class);
        } catch (Exception e) {
            return null;
        }
    }

}
