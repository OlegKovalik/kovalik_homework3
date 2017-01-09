package com.example.oleg.kovalik_homework3;

/**
 * Created by Oleg on 08.01.2017.
 */
public class Constants {
    public static final String BASE_URL = "https://api.instagram.com";
    public static final String CLIENT_ID = "b648748efe124d03bcff5cff78258855";
    public static final String CLIENT_SECRET = "011581ebeeb047618d134fa939659966";
    public static final String REDIRECT_URI = "http://yourcallback.com/";
    public static final String REDIRECT_QUERY = "?code=";
    public static final String START_REQUEST = BASE_URL + "/oauth/authorize/?client_id=" + CLIENT_ID + "&redirect_uri=" + REDIRECT_URI + "&response_type=code";



    public static final String CODE_KEY = "code";



}
