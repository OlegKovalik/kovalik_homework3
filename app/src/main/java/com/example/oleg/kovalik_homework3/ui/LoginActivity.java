package com.example.oleg.kovalik_homework3.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import com.example.oleg.kovalik_homework3.R;
import com.example.oleg.kovalik_homework3.model.MyWebViewClient;

import static com.example.oleg.kovalik_homework3.Constants.START_REQUEST;


public class LoginActivity extends AppCompatActivity {
    private WebView v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        final EditText login = (EditText) findViewById(R.id.login);
        final EditText password = (EditText) findViewById(R.id.password);
        Button button = (Button) findViewById(R.id.login_button);

        v = (WebView) findViewById(R.id.web_login);
        v.setWebViewClient(new MyWebViewClient());
        v.getSettings().setJavaScriptEnabled(true);
        v.getSettings().setDomStorageEnabled(true);
        v.getSettings().setLoadsImagesAutomatically(false);
        v.getSettings().setSavePassword(false);
        v.getSettings().setSaveFormData(false);
        v.setVisibility(View.INVISIBLE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v.loadUrl("javascript: {" +
                        "document.getElementById('id_username').value = '" + login.getText().toString() + "';" +
                        "document.getElementById('id_password').value = '" + password.getText().toString() + "';" +
                        "var frms = document.getElementById('login-form');" +
                        "frms.submit(); };");

            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        v.loadUrl(START_REQUEST);

    }


}
