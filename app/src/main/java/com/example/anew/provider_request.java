package com.example.anew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;

public class provider_request extends AppCompatActivity {
    Toolbar toolbar;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_request);

        final String newString;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                newString = null;
            } else {
                newString = extras.getString("user_id");
            }
        } else {
            newString = (String) savedInstanceState.getSerializable("STRING_I_NEED");
        }

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(" ");

        webView = (WebView) findViewById(R.id.web);
        webView.loadUrl("http://192.168.2.2/awarenes/Admin/Android_Adminn/app_provider_request.php?user_id=" + newString);
    }
}
