package com.realty.autosolving.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by vitaliy on 5/5/2016.
 */
@Setter
@Getter
@Entity
@Table(name = "city")
public class City {
    @Id
    private Integer id;
    private String title;
    private String url;
}
