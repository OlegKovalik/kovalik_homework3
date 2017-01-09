package com.example.oleg.kovalik_homework3.model;

import android.content.Intent;
import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.example.oleg.kovalik_homework3.R;
import com.example.oleg.kovalik_homework3.ui.ProfileActivity;

import static com.example.oleg.kovalik_homework3.Constants.*;


/**
 * Created by Oleg on 06.01.2017.
 */
public class MyWebViewClient extends WebViewClient {

    private boolean flagStop = false;
    private boolean flagRedirect = true;


    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        System.out.println("Url: " + url);

        if (url.contains(REDIRECT_URI + REDIRECT_QUERY)) {
            Intent intent = new Intent(view.getContext(), ProfileActivity.class);
            System.out.println(url.substring(url.lastIndexOf(REDIRECT_QUERY) + REDIRECT_QUERY.length()));
            intent.putExtra(CODE_KEY, url.substring(url.lastIndexOf(REDIRECT_QUERY) + REDIRECT_QUERY.length()));
            view.getContext().startActivity(intent);
        } else {
            view.loadUrl(url);
        }

        flagRedirect = true;
        flagStop = false;

        return true;

    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        flagRedirect = false;
        System.out.println("Start: " + url);

    }

    @Override
    public void onPageFinished(WebView view, String url) {
        System.out.println("Redirect: " + flagRedirect);
        System.out.println("Stop: " + flagStop);
        System.out.println("End: " + url);

        if (!flagRedirect && !flagStop) {
            flagStop = true;
            System.out.println("Final url:" + url);
        }


    }

    @Override
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        Toast.makeText(view.getContext(), view.getResources().getString(R.string.error_connected) + description, Toast.LENGTH_LONG).show();
    }
}
