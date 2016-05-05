package com.realty.autosolving;

import com.realty.autosolving.util.AlphabetHelper;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.*;

/**
 * Created by vitaliy on 5/1/2016.
 */
public class AlphabetHelperTest {

    @Test
    public void testGetAllCombination() throws Exception {
        List<String> allCombination = AlphabetHelper.getAllCombination();
        assertTrue(allCombination.size() == 1056);
    }
}