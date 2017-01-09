package com.example.oleg.kovalik_homework3.gson;

/**
 * Created by Oleg on 07.01.2017.
 */
public class UserDetails {
    private Meta meta;
    private User data;

    public UserDetails() {
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "meta=" + meta.toString() +
                ", data=" + data.toString() +
                '}';
    }
}
