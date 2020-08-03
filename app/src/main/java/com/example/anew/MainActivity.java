package com.example.anew;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static int TIME_SET=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences preferences = getSharedPreferences("user", Context.MODE_PRIVATE);
                String id = preferences.getString("userid","");
                if(!id.equals("")) {
                    Intent intent = new Intent(MainActivity.this, cardview.class);
                    startActivity(intent);
                    finish();
                }else {
                    Intent intent = new Intent(MainActivity.this, User_serviceprovider.class);
                    startActivity(intent);
                    finish();
                }
            }
        },TIME_SET);
    }
}
