package com.realty.autosolving.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.realty.autosolving.pojo.UpDateStatus;
import com.realty.facade.CityFacade;

@RestController
@RequestMapping("auto-filling")
public class AutoFillingController {
    @Autowired
    private CityFacade cityFacade;

    @RequestMapping("/city")
    public UpDateStatus fillCities() {
        int amount = cityFacade.upgradeCitiesAutomatically();
        return new UpDateStatus("inserted", amount);
    }
}
