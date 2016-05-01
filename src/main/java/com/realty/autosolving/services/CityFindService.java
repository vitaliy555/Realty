package com.realty.autosolving.services;

import com.google.common.collect.Lists;
import com.realty.autosolving.dot.City;
import com.realty.autosolving.dot.CityList;
import com.realty.autosolving.errors.CitySuggestAPIException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.realty.autosolving.AlphabetHelper.getAllCombination;
import static com.realty.autosolving.services.OLXResponceSatus.OK;

/**
 * Created by vitaliy on 4/29/2016.
 */
@Slf4j
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
        if (OK.equals(cityList.getStatus())) {
            log.error("Bad response: " + cityList);
            throw new CitySuggestAPIException("Bad response: " + cityList.getStatus().name());
        } else {
            return cityList.getListOfCities();
        }
    }


}
