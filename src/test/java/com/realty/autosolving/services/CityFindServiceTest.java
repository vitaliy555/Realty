package com.realty.autosolving.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by vitaliy on 5/2/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/context.xml")
public class CityFindServiceTest {
    @Autowired
    private CityFindService cityFindService;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testhistFindAllExistCities() throws Exception {
        System.out.println(cityFindService.findAllExistCities());
    }
}