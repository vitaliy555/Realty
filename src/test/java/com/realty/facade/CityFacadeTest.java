package com.realty.facade;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by vitaliy on 5/16/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/context.xml")
public class CityFacadeTest {
    @Autowired
    private CityFacade cityFacade;

    @Test
    public void testUpgradeCitiesAutomatically() throws Exception {
        cityFacade.upgradeCitiesAutomatically();
    }
}