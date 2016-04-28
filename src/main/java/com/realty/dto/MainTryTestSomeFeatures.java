package com.realty.dto;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class MainTryTestSomeFeatures {
    public  void main(String[] args) throws IOException {
        RestTemplate rest = new RestTemplate();
        MultiValueMap<String, Object> parts = new
                LinkedMultiValueMap<String, Object>();
        parts.add("data", "дн");
        String cityListResponseEntity = rest.postForObject("http://olx.ua/ajax/geo6/autosuggest/", parts, String.class);
        System.out.println(cityListResponseEntity);
    }
}
