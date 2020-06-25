package com.example.anew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class serviceprovider extends AppCompatActivity {
    Button btnssign,btnsregister;
    TextView tvsterm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serviceprovider);

        btnsregister=(Button)findViewById(R.id.btnsregister);
        btnssign=(Button)findViewById(R.id.btnssign);
        tvsterm=(TextView)findViewById(R.id.tvsterm);
        btnsregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bd = new Bundle();
                Intent intent = new Intent(serviceprovider.this, servicesignup.class);
                startActivity(intent);

            }

        });
        tvsterm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bd = new Bundle();
                Intent intent = new Intent(serviceprovider.this, termscondition.class);
                startActivity(intent);

            }

        });
        btnssign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bd = new Bundle();
                Intent intent = new Intent(serviceprovider.this, servicelogin.class);
                startActivity(intent);

            }
        });
    }
}
