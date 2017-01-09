package com.example.oleg.kovalik_homework3.Requests;

import com.example.oleg.kovalik_homework3.gson.UserDetails;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Oleg on 08.01.2017.
 */
public interface RequestUsedDetails {
    @GET("/v1/users/self/")
    Call<UserDetails> getUserDetails(@Query("access_token") String accessToken);

}
