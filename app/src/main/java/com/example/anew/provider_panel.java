package com.example.anew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class provider_panel extends AppCompatActivity {
    Toolbar toolbar;
    Button request, change_pass,logout,feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_panel);

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
        request = (Button) findViewById(R.id.request);
        change_pass = (Button) findViewById(R.id.change_pass);
        feedback = (Button) findViewById(R.id.feedback);
        logout= (Button) findViewById(R.id.logout);


        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(provider_panel.this, sfeed.class);
                startActivity(intent);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(provider_panel.this, servicelogin.class);
                startActivity(intent);
                finish();
            }
        });


        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bd1 = new Bundle();
                Intent intent = new Intent(provider_panel.this, service_man_req.class);
                bd1.putString("user_id", newString);
                intent.putExtras(bd1);
                startActivity(intent);
            }
        });

        change_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bd1 = new Bundle();
                Intent intent = new Intent(provider_panel.this, scw.class);
                bd1.putString("user_id", newString);
                intent.putExtras(bd1);
                startActivity(intent);
            }
        });
    }
}
