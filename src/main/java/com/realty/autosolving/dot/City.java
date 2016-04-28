package com.realty.autosolving.dot;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

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
