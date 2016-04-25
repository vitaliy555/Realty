package com.realty.autosolving;

import com.realty.autosolving.dot.CityList;

import org.apache.catalina.util.URLEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class CitySuggest {
    private static final String CITY_SUGGEST_URL = "http://olx.ua/ajax/geo6/autosuggest/";
    @Autowired
    private RestTemplate rest;

    public void findCities() throws UnsupportedEncodingException {
//        MultiValueMap headers = new HttpHeaders();
        rest=new RestTemplate();
        rest.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//        headers.add(HttpHeaders.USER_AGENT,"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36");
//        headers.add(HttpHeaders.CONTENT_TYPE,"application/x-www-form-urlencoded");
//        headers.add("POST","/ajax/geo6/autosuggest/ HTTP/1.1");
//        headers.add(HttpHeaders.HOST,"olx.ua");
//        headers.add(HttpHeaders.ACCEPT,"*/*");

        String requestJson = "data=дн&withRegions=1";
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE,"application/x-www-form-urlencoded");
        headers.set(HttpHeaders.USER_AGENT,"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36");
        headers.set("POST","/ajax/geo6/autosuggest/ HTTP/1.1");
        headers.set(HttpHeaders.HOST,"olx.ua");
        headers.set(HttpHeaders.ACCEPT,"*/*");
//        headers.set("data","дн"); headers.set("withRegions","1");
        Map data = new HashMap(){{put("data","дн");put("withRegions","1");}};

        HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);
        String cityListResponseEntity = rest.postForObject(CITY_SUGGEST_URL,entity , String.class);
        System.out.println(cityListResponseEntity);
    }
}

