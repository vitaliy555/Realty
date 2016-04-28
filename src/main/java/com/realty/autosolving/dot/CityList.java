package com.realty.autosolving.dot;

import java.util.Collections;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
public class CityList {
    private String status;
    @JsonProperty("data")
    private List<City> listOfCities ;

}
