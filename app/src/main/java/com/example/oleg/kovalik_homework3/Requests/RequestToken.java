package com.example.oleg.kovalik_homework3.Requests;

import com.example.oleg.kovalik_homework3.gson.Authentication;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Oleg on 08.01.2017.
 */
public interface RequestToken {
    @FormUrlEncoded
    @POST("/oauth/access_token")
    Call<Authentication> getToken(@Field("client_id") String clientId,
                                  @Field("client_secret") String clientSecret,
                                  @Field("grant_type") String grantType,
                                  @Field("redirect_uri") String redirectUri,
                                  @Field("code") String code);

}
