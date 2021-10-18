package com.esb.util;

import org.apache.commons.lang3.RandomStringUtils;

public class Random {
    public static String generateRandom(){
        String randomString = "GBS" + RandomStringUtils.random(10,false,true);
        return randomString;
    }
}
