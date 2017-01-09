package com.example.oleg.kovalik_homework3.gson;

/**
 * Created by Oleg on 07.01.2017.
 */
public class Meta {
    private String code;

    public Meta() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Meta{" +
                "code='" + code + '\'' +
                '}';
    }
}
