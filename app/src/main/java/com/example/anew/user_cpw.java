package com.example.anew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;

//public class user_cpw extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_user_cpw);
//
//
//    }
//}


public class user_cpw extends AppCompatActivity {
    Toolbar toolbar;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_cpw);

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
        webView.loadUrl("http://192.168.43.234/awarenes/Admin/Android_Adminn/app_user_cpw.php?user_id=" + newString);
    }
}