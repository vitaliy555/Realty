package com.realty.autosolving.model;

import org.hibernate.annotations.Cache;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by vitaliy on 5/5/2016.
 */
@Setter
@Getter
@Entity
@Table(name = "city")
//TODO @Cache()
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String url;
}
