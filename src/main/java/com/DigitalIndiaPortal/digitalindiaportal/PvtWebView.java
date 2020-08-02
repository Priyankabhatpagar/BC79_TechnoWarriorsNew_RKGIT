package com.DigitalIndiaPortal.digitalindiaportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class PvtWebView extends AppCompatActivity {
    String pvturl;
    WebView pvtWebView;
    ProgressBar pvtwebProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvt_web_view);
        pvtWebView=findViewById(R.id.pvtWebView);
        pvtwebProgressBar=findViewById(R.id.pvtwebProgress);
        Intent pvtIntent =getIntent();
          pvturl=pvtIntent.getStringExtra("pvtWebUrl");
          pvtWebView.setWebViewClient(new WebViewClient());
          pvtWebView.getSettings().setJavaScriptEnabled(true);
          pvtWebView.loadUrl(pvturl);
    }
    class WebViewClient extends android.webkit.WebViewClient{
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            pvtwebProgressBar.setVisibility(View.GONE);
        }
    }
}