package com.realty.dto.autosuggest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class CitySuggest {
    private static final String CITY_SUGGEST_URL = "olx.ua/ajax/geo6/autosuggest/";
    @Autowired
    private RestTemplate rest;

    public void findCities(){
        rest.postForEntity(CITY_SUGGEST_URL,/)
    }
}
