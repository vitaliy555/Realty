package com.realty.facade;

import com.realty.autosolving.converter.OLXCityListConverter;
import com.realty.autosolving.dto.OLXCity;
import com.realty.autosolving.model.City;
import com.realty.autosolving.services.CityFindService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityFacade {
    @Autowired
    private CityFindService cityFindService;
    @Autowired
    private OLXCityListConverter cityListConverter;
    @Autowired
    private SessionFactory sessionFactory;

    public int upgradeCitiesAutomatically() {
        List<OLXCity> allExistCities = cityFindService.findAllExistCities();
        List<City> cities = cityListConverter.convert(allExistCities);
        Session session = sessionFactory.openSession();
        cities.forEach(city -> session.save(city));
        session.close();
        return cities.size();
    }

}