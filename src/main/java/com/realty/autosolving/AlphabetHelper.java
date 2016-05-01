package com.realty.autosolving;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by vitaliy on 5/1/2016.
 */
public class AlphabetHelper {
    private static String RU_ALPHABET_IN_LINE = "ÀÁÂÃÄÅ¨ÆÇÈÉÊËÌÍÎÏĞÑÒÓÔÕÖ×ØÙÚÛÜİŞß";

    public static List<String> getAllCombination() {
        List<String> combinaions = Lists.newArrayList();
        for (int i = 0; i < RU_ALPHABET_IN_LINE.length(); i++) {
            String firstLetter = String.valueOf(RU_ALPHABET_IN_LINE.charAt(i));
            for (int j = 0; j < RU_ALPHABET_IN_LINE.length(); j++) {
                String secondLetter = String.valueOf(RU_ALPHABET_IN_LINE.charAt(j));
                if (!firstLetter.equals(secondLetter)) {
                    combinaions.add(firstLetter.concat(secondLetter));
                }
            }
        }
        return combinaions;
    }
}
