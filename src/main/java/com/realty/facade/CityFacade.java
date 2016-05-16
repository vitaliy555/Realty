package com.realty.facade;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import com.realty.autosolving.converter.OLXCityListConverter;
import com.realty.autosolving.dto.OLXCity;
import com.realty.autosolving.model.City;
import com.realty.autosolving.services.CityFindService;
import org.springframework.stereotype.Component;

@Component
public class CityFacade {
    @Autowired
    private CityFindService cityFindService;
    @Autowired
    private OLXCityListConverter cityListConverter;


    public int upgradeCitiesAutomatically() {
        List<OLXCity> allExistCities = cityFindService.findAllExistCities();
        List<City> cities = cityListConverter.convert(allExistCities);

        Session currentSession = getSessionFactory().getCurrentSession();
        currentSession.save(cities);
        return cities.size();
    }

    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration
                .buildSessionFactory(builder.build());
        return sessionFactory;
    }
}