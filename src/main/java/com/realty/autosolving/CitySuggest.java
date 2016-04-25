package com.realty.autosolving;

import com.realty.autosolving.dot.CityList;

import org.apache.catalina.util.URLEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;

public class CitySuggest {
    private static final String CITY_SUGGEST_URL = "http://olx.ua/ajax/geo6/autosuggest/";
    @Autowired
    private RestTemplate rest;

    public void findCities() throws UnsupportedEncodingException {
        MultiValueMap headers = new HttpHeaders();
        rest=new RestTemplate();
        headers.add(HttpHeaders.USER_AGENT,"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36");
        headers.add(HttpHeaders.CONTENT_TYPE,"application/x-www-form-urlencoded");
        ResponseEntity<CityList> cityListResponseEntity = rest.postForEntity(CITY_SUGGEST_URL, java.net.URLEncoder.encode("data=%D0%B4%D0%BD&withRegions=1","UTF-8"), CityList.class);
    }
}

