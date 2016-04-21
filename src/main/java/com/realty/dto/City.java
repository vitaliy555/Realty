package com.realty.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City {
    private Integer id;
    private String name;

}
