package com.realty.autosolving.services;

import com.realty.autosolving.dot.CityList;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Created by vitaliy on 4/29/2016.
 */
public class CityFindService {
    MultiValueMap<String, Object> form = new LinkedMultiValueMap<String, Object>();

    //TODO @autowire
    private RestTemplate rest = new RestTemplate();
    private String cityUrl = "http://olx.ua/ajax/geo6/autosuggest/";

    public CityList findAllExistCities() {
        MultiValueMap<String, Object> form = new LinkedMultiValueMap<String, Object>();
        form.add("data", "дн");
        CityList cityList = rest.postForObject(cityUrl, form, CityList.class);
        return cityList;
    }

    /**
     * Attempt receive cities by phrase from remote api
     * @param phrase only 2 chars
     * @return
     */
    private CityList suggestCitiesByPhrase(String phrase){
        form.add("data",phrase);
        CityList cityList = rest.postForObject(cityUrl, form, CityList.class);

    }


}
