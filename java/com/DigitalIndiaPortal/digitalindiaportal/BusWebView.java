package com.DigitalIndiaPortal.digitalindiaportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BusWebView extends AppCompatActivity {
    WebView busWeb;
    String busUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_web_view);
        busWeb=findViewById(R.id.busWebView);
        Intent bus =getIntent();
        busUrl=bus.getStringExtra("busUrl");
        busWeb.setWebViewClient(new WebViewClient());
        busWeb.getSettings().setJavaScriptEnabled(true);
        busWeb.loadUrl(busUrl);

    }
}