package com.realty.facade;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.realty.autosolving.converter.OLXCityListConverter;
import com.realty.autosolving.dto.OLXCity;
import com.realty.autosolving.model.City;
import com.realty.autosolving.services.CityFindService;

@Component
public class CityFacade {
    @Autowired
    private CityFindService cityFindService;
    @Autowired
    private OLXCityListConverter cityListConverter;
    @Autowired
    private SessionFactory sessionFactory;

    public int upgradeCitiesAutomatically() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(City.class);
        List<City> persistedCities = criteria.list();
        if (persistedCities.stream().count() <= 0) {
            List<OLXCity> allExistCities = cityFindService.findAllExistCities();
            persistedCities = cityListConverter.convert(allExistCities);
            persistedCities.forEach(city -> session.save(city));
        }
        session.close();
        return persistedCities.size();
    }

}
