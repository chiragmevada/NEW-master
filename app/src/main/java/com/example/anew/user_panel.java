package com.example.anew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class user_panel extends AppCompatActivity {
    Toolbar toolbar;
    WebView webView;
    Button request, change_pass,add_request,logout,feedback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_panel);

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

        request = (Button) findViewById(R.id.request);
        change_pass = (Button) findViewById(R.id.change_pass);
        add_request = (Button) findViewById(R.id.add_request);
        feedback = (Button) findViewById(R.id.feedback);
        logout= (Button) findViewById(R.id.logout);

        add_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bd1 = new Bundle();
                Intent intent = new Intent(user_panel.this, cardview.class);
                bd1.putString("user_id", newString);
                intent.putExtras(bd1);
                startActivity(intent);
            }
        });

        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(user_panel.this, feedback.class);
                startActivity(intent);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(user_panel.this, login.class);
                startActivity(intent);
                finish();
            }
        });

        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bd1 = new Bundle();
                Intent intent = new Intent(user_panel.this, user_request.class);
                bd1.putString("user_id", newString);
                intent.putExtras(bd1);
                startActivity(intent);
            }
        });

        change_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bd1 = new Bundle();
                Intent intent = new Intent(user_panel.this, user_cpw.class);
                bd1.putString("user_id", newString);
                intent.putExtras(bd1);
                startActivity(intent);
            }
        });
    }
}
