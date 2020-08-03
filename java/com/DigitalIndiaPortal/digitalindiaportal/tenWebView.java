package com.DigitalIndiaPortal.digitalindiaportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class tenWebView extends AppCompatActivity {
   WebView tenWebView;
   String tenUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ten_web_view);
        tenWebView=findViewById(R.id.tenWebView);
        Intent url=getIntent();
        tenUrl=url.getStringExtra("tenUrl");
        tenWebView.setWebViewClient(new WebViewClient());
        tenWebView.getSettings().setJavaScriptEnabled(true);
        tenWebView.loadUrl(tenUrl);

    }
}