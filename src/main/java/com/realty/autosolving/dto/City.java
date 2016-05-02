package com.realty.autosolving.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class City {
    private int id;
    private String text;
    private String text_simple;
    private String text_gray;
    private double lon;
    private double lat;
    private int zoom;
    private String url;

}
