package com.example.anew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;

public class CategoryActivity extends AppCompatActivity {
    Toolbar toolbar;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(" ");

        webView = (WebView) findViewById(R.id.web);
        webView.loadUrl("http://192.168.0.177/awarenes/Admin/Android_Adminn/app_category.php");
    }
}
