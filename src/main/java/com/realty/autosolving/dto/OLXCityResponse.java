package com.realty.autosolving.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OLXCityResponse {
    private OLXResponseSatus status;
    @JsonProperty("data")
    private List<OLXCity> olxCities ;

}
