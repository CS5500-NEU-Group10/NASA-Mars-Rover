package com.cs5500group10;

import com.cs5500group10.response.MarsRoverApiResponse;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * The Class MarsRoverApiTest.
 */
public class MarsRoverApiTest {

    /**
     * Small test to see if it returns correct JSON response.
     */
    @Test
    public void smallTest() {
        RestTemplate rt = new RestTemplate();

        ResponseEntity<MarsRoverApiResponse> response =
                rt.getForEntity("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY", MarsRoverApiResponse.class);
        System.out.println(response.getBody());
    }
}
