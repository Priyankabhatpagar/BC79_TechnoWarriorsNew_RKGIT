package com.DigitalIndiaPortal.digitalindiaportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class FreeWebView extends AppCompatActivity {
    WebView freeWebView;
     String freeUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_web_view);
        freeWebView=findViewById(R.id.freeWebView);
        Intent url=getIntent();
        freeUrl=url.getStringExtra("freeUrl");
        freeWebView.setWebViewClient(new WebViewClient());
        freeWebView.getSettings().setJavaScriptEnabled(true);
        freeWebView.loadUrl(freeUrl);
    }
}