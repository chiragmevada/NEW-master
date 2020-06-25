package com.example.anew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class map extends AppCompatActivity {
    Toolbar toolbar;
    WebView webView;
    Button request, feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(" ");

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

        webView = (WebView) findViewById(R.id.web);
        webView.loadUrl("http://192.168.0.177/awarenes/Admin/Android_Adminn/app_location_provider.php");

        request = (Button) findViewById(R.id.request);
        feedback = (Button) findViewById(R.id.feedback);

        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(map.this, feedback.class);
                startActivity(intent);
            }
        });

        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bd1 = new Bundle();
                Intent intent = new Intent(map.this, provider_panel.class);
                bd1.putString("user_id", newString);
                intent.putExtras(bd1);
                startActivity(intent);
            }
        });

    }
}
