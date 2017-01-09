package com.example.oleg.kovalik_homework3.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.oleg.kovalik_homework3.R;
import com.example.oleg.kovalik_homework3.gson.UserDetails;
import com.example.oleg.kovalik_homework3.model.InstaRequestTask;

import static com.example.oleg.kovalik_homework3.Constants.CODE_KEY;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        System.out.println(extras.getString(CODE_KEY));


        InstaRequestTask instaRequestTask = new InstaRequestTask() {
            @Override
            public void onDone(UserDetails userDetails, Bitmap profilePic) {
                System.out.println(userDetails);


                ((ImageView) findViewById(R.id.profile_picture)).setImageBitmap(profilePic);
                ((TextView) findViewById(R.id.username)).setText(userDetails.getData().getUserName());
                ((TextView) findViewById(R.id.bio)).setText(userDetails.getData().getBio());
                ((TextView) findViewById(R.id.website)).setText(userDetails.getData().getWebsite());
                ((TextView) findViewById(R.id.full_name)).setText(userDetails.getData().getFullName());
                ((TextView) findViewById(R.id.inst_id)).setText(userDetails.getData().getId());
                ((TextView) findViewById(R.id.media_inst)).setText("" + userDetails.getData().getCounts().getMedia());
                ((TextView) findViewById(R.id.followed_by)).setText("" + userDetails.getData().getCounts().getFollowedBy());
                ((TextView) findViewById(R.id.follows)).setText("" + userDetails.getData().getCounts().getFollows());

            }
        };
        instaRequestTask.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, extras.getString(CODE_KEY));
    }

}
