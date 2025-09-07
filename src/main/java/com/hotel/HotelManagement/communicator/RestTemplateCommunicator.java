package com.hotel.HotelManagement.communicator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateCommunicator {

    private final RestTemplate restTemplate;

    @Autowired
    public RestTemplateCommunicator(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate=restTemplateBuilder.build();
    }


    public Float getActualHotelRating(Long hotelid){
        String url="http://localhost:8084/rating/getratingbyhotelid/"+hotelid;
        ResponseEntity<Float> hotelRating = restTemplate.getForEntity(url,Float.class);
        return  hotelRating.getBody();

    }

}
