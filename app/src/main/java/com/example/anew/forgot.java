package com.example.anew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class forgot extends AppCompatActivity {
    TextView tvllogin1,tvb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        tvllogin1 = (TextView) findViewById(R.id.tvllogin1);
        tvb1 = (TextView) findViewById(R.id.tvb1);

        tvllogin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(forgot.this,login.class);
                startActivity(intent);
                finish();
            }
        });
        tvb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(forgot.this,login.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
