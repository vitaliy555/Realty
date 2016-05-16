package com.realty.autosolving.converter;

import java.util.List;

import org.springframework.core.convert.converter.Converter;

import com.google.common.collect.Lists;
import com.realty.autosolving.dto.OLXCity;
import com.realty.autosolving.model.City;
import org.springframework.stereotype.Component;

@Component
public class OLXCityListConverter implements Converter<List<OLXCity>, List<City>> {

    @Override
    public List<City> convert(List<OLXCity> source) {
        List<City> cities = Lists.newArrayList();
        source.forEach(olxCity -> cities.add(convertToCity(olxCity)));
        return cities;
    }

    private City convertToCity(OLXCity olxCity) {
        City city = new City();
        city.setId(olxCity.getId());
        city.setTitle(olxCity.getText_simple());
        city.setUrl(olxCity.getUrl());
        return city;
    }
}
