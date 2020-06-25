package com.example.anew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class view extends AppCompatActivity {
Button btnvsign,btnvlog;
TextView tvterms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        btnvlog=(Button)findViewById(R.id.btnvlog);
        btnvsign=(Button)findViewById(R.id.btnvsign);
        tvterms=(TextView)findViewById(R.id.tvterms);
        btnvsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bd = new Bundle();
                Intent intent = new Intent(view.this, signup.class);
                startActivity(intent);

            }

        });
        tvterms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bd = new Bundle();
                Intent intent = new Intent(view.this, termscondition.class);
                startActivity(intent);

            }

        });
        btnvlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bd = new Bundle();
                Intent intent = new Intent(view.this, login.class);
                startActivity(intent);

            }
        });
    }
}
