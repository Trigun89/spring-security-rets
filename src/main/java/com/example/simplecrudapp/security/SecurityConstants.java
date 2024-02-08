package com.example.simplecrudapp.security;

import com.example.simplecrudapp.SpringApplicationContext;

public class SecurityConstants {
    public static final long EXPIRATION_TIME = 432000000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users";
    //public static final String TOKEN_SECRET = "W4iLCJJc3N1ZXIiOiJJc3N1ZXIiLCJVc2Vybm";

    public static String getTokenSecret(){
        AppProperties appProperties = (AppProperties) SpringApplicationContext.getBean("AppProperties");
        return appProperties.getTokenSecret();
    }
}
