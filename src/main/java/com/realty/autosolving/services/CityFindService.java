package com.realty.autosolving.services;

import static com.realty.autosolving.util.AlphabetHelper.getAllCombination;
import static com.realty.autosolving.dto.OLXResponseSatus.ok;

import java.util.Collections;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.Lists;
import com.realty.autosolving.dto.OLXCity;
import com.realty.autosolving.dto.OLXCityResponse;

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
    public List<OLXCity> findAllExistCities() {
        List<OLXCity> olxAllCities = Lists.newArrayList();
//        for (String phrase : getAllCombination()) {
//            olxAllCities.addAll(suggestCitiesByPhrase(phrase));
//        }
        return olxAllCities;
    }

    /**
     * Attempt receive cities by phrase from remote api
     *
     * @param phrase - two letters
     * @return
     */
    private List<OLXCity> suggestCitiesByPhrase(String phrase) {
        MultiValueMap<String, Object> form = new LinkedMultiValueMap<String, Object>();
        form.add("data", phrase);
        OLXCityResponse OLXCityResponse = rest.postForObject(cityUrl, form, OLXCityResponse.class);
        List<OLXCity> olxCities ;
        if (ok.equals(OLXCityResponse.getStatus())) {
            olxCities = OLXCityResponse.getOlxCities();
        } else {
            log.info(String.format("Request: %s  Response: %s", form, OLXCityResponse));
            olxCities= Collections.EMPTY_LIST;
        }
        return olxCities;
    }

}
