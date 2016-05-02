package com.realty.autosolving.dto;

import java.util.List;

import com.realty.autosolving.services.OLXResponceSatus;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CityList {
    private OLXResponceSatus status;
    @JsonProperty("data")
    private List<City> listOfCities ;

}
