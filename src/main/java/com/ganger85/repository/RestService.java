package com.ganger85.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class RestService implements com.ganger85.domain.RemoteService {

    private final RestTemplate restTemplate;

    private final String url = "https://apidev.meep.me/tripplan/api/v1/routers/lisboa/resources?\n" +
            "lowerLeftLatLon=38.711046,-9.160096&upperRightLatLon=38.739429,-\n" +
            "9.137115&companyZoneIds=545,467,473";

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public List<LinkedHashMap> getRecordList() throws JsonProcessingException {
        String response = restTemplate.getForObject(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response, List.class);
    }
}
