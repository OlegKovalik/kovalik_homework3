package com.example.oleg.kovalik_homework3.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Oleg on 07.01.2017.
 */
public class Authentication {
    @SerializedName("access_token")
    private String accessToken;
    private User user;

    public Authentication() {
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Authentication{" +
                "accessToken='" + accessToken + '\'' +
                ", user=" + user +
                '}';
    }
}
