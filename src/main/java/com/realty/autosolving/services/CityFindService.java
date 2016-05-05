package com.realty.autosolving.services;

import static com.realty.autosolving.AlphabetHelper.getAllCombination;
import static com.realty.autosolving.services.OLXResponceSatus.ok;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.Lists;
import com.realty.autosolving.dto.City;
import com.realty.autosolving.dto.CityList;

/**
 * Created by vitaliy on 4/29/2016.
 */
@Slf4j
@Service
public class CityFindService {
    private static String cityUrl = "http://olx.ua/ajax/geo6/autosuggest/";

    @Autowired
    private RestTemplate rest;

    /**
     * Receive all cities from remote API
     *
     * @return
     */
    public List<City> findAllExistCities() {
        List<City> cities = Lists.newArrayList();
        for (String phrase : getAllCombination()) {
            cities.addAll(suggestCitiesByPhrase(phrase));
        }
        return cities;
    }

    /**
     * Attempt receive cities by phrase from remote api
     *
     * @param phrase - two letters
     * @return
     */
    private List<City> suggestCitiesByPhrase(String phrase) {
        MultiValueMap<String, Object> form = new LinkedMultiValueMap<String, Object>();
        form.add("data", phrase);
        CityList cityList = rest.postForObject(cityUrl, form, CityList.class);
        List<City> result = Lists.newArrayList();
        if (ok.equals(cityList.getStatus())) {
            result = cityList.getListOfCities();
        } else {
            log.debug(String.format("Request: %s \nResponse: %s", form, cityList));
        }
        return result;
    }

}
