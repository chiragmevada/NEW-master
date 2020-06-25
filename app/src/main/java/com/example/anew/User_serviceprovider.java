package com.example.anew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class User_serviceprovider extends AppCompatActivity {

    Button btnuser,btnservice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_serviceprovider);
        btnuser=(Button)findViewById(R.id.btnuser);
        btnservice=(Button)findViewById(R.id.btnservice);

        btnuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(User_serviceprovider.this, view.class);
                startActivity(intent);
              //  finish();
            }
        });

        btnservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(User_serviceprovider.this, serviceprovider.class);
                startActivity(intent);
                //finish();
            }
        });
    }
}
