package com.example.oleg.kovalik_homework3.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import com.example.oleg.kovalik_homework3.Constants;
import com.example.oleg.kovalik_homework3.Requests.RequestToken;
import com.example.oleg.kovalik_homework3.Requests.RequestUsedDetails;
import com.example.oleg.kovalik_homework3.gson.Authentication;
import com.example.oleg.kovalik_homework3.gson.UserDetails;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.net.URL;

import static com.example.oleg.kovalik_homework3.Constants.*;


/**
 * Created by Oleg on 08.01.2017.
 */
public abstract class InstaRequestTask extends AsyncTask<String, Boolean, UserDetails> {
    private Retrofit client;
    private Bitmap profilePic = null;


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        client = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }


    @Override
    protected UserDetails doInBackground(String... params) {

        RequestToken authenticationClient = client.create(RequestToken.class);
        Call<Authentication> callAuthentication = authenticationClient.getToken(CLIENT_ID, CLIENT_SECRET, "authorization_code", REDIRECT_URI, params[0]);
        Authentication authentication = new Authentication();
        try {
            authentication = callAuthentication.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }


        RequestUsedDetails userDetailsClient = client.create(RequestUsedDetails.class);
        Call<UserDetails> callUserDetails = userDetailsClient.getUserDetails(authentication.getAccessToken());
        UserDetails userDetails = new UserDetails();
        try {
            userDetails = callUserDetails.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            profilePic = BitmapFactory.decodeStream(new URL(userDetails.getData().getProfilePicture()).openConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }


        return userDetails;
    }

    @Override
    protected void onPostExecute(UserDetails userDetails) {
        super.onPostExecute(userDetails);
        onDone(userDetails, profilePic);

    }

    abstract public void onDone(UserDetails userDetails, Bitmap profilePic);
}
