package com.realty.dto;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.Charset;

public class MainTryTestSomeFeatures {
    public static void main(String[] args) throws IOException {
        for (byte b : "A".getBytes("UTF-8")) {
            System.out.println(b);
        }
        for (byte b : "Â".getBytes("UTF-8")) {
            System.out.println(b);
        }
        for (byte b : "ß".getBytes("UTF-8")) {
            System.out.println(b);
        }

        System.out.println("A".getBytes("UTF-8"));
    }
}
