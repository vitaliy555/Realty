package com.realty.autosolving.facade;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.realty.autosolving.converter.OLXCityListConverter;
import com.realty.autosolving.dto.OLXCity;
import com.realty.autosolving.model.City;
import com.realty.autosolving.services.CityFindService;

public class CityFacade {
    @Autowired
    private CityFindService cityFindService;
    @Autowired
    private OLXCityListConverter cityListConverter;

    private Session session;

    public int upgradeCitiesAutomatically() {
        List<OLXCity> allExistCities = cityFindService.findAllExistCities();
        List<City> cities = cityListConverter.convert(allExistCities);
        session.save(cities);
        return cities.size();
    }
}
