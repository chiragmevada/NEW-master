package com.example.anew;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class cardview extends AppCompatActivity {
    CardView cd1, cd2, cd3, cd4, cd5, cd6, cd7, cd8, cd9;
    TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9;
    RelativeLayout cd;
    Toolbar toolbar;
    Button request, feedback;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardview);

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

        cd1 = (CardView) findViewById(R.id.cd1);
        cd2 = (CardView) findViewById(R.id.cd2);
        cd3 = (CardView) findViewById(R.id.cd3);
        cd4 = (CardView) findViewById(R.id.cd4);
        cd5 = (CardView) findViewById(R.id.cd5);
        cd6 = (CardView) findViewById(R.id.cd6);
        cd7 = (CardView) findViewById(R.id.cd7);
        cd8 = (CardView) findViewById(R.id.cd8);
        cd9 = (CardView) findViewById(R.id.cd9);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv5 = (TextView) findViewById(R.id.tv5);
        tv6 = (TextView) findViewById(R.id.tv6);
        tv7 = (TextView) findViewById(R.id.tv7);
        tv8 = (TextView) findViewById(R.id.tv8);
        tv9 = (TextView) findViewById(R.id.tv9);
        cd = (RelativeLayout) findViewById(R.id.cd);

        toolbar = (Toolbar) findViewById(R.id.actionbar);
        toolbar.setTitle(" ");

        request = (Button) findViewById(R.id.request);
        feedback = (Button) findViewById(R.id.feedback);

        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cardview.this, feedback.class);
                startActivity(intent);
            }
        });

        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String val_tv1 = tv1.getText().toString();
                Bundle bd1 = new Bundle();
                Intent intent = new Intent(cardview.this, user_panel.class);
                bd1.putString("user_id", newString);
                intent.putExtras(bd1);
                startActivity(intent);
            }
        });

        cd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val_tv1 = tv1.getText().toString();
                Bundle bd1 = new Bundle();
                Intent intent = new Intent(cardview.this, select.class);
                bd1.putString("a", val_tv1);
                bd1.putString("user_id", newString);
                intent.putExtras(bd1);
                startActivity(intent);

            }
        });
        cd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val_tv2 = tv2.getText().toString();
                Bundle bd2 = new Bundle();
                Intent intent = new Intent(cardview.this, select.class);

                bd2.putString("a", val_tv2);
                bd2.putString("user_id", newString);
                intent.putExtras(bd2);
                startActivity(intent);
            }
        });
        cd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val_tv3 = tv3.getText().toString();
                Bundle bd3 = new Bundle();
                Intent intent = new Intent(cardview.this, select.class);

                bd3.putString("a", val_tv3);
                bd3.putString("user_id", newString);
                intent.putExtras(bd3);
                startActivity(intent);

            }
        });
        cd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val_tv4 = tv4.getText().toString();
                Bundle bd4 = new Bundle();
                Intent intent = new Intent(cardview.this, select.class);

                bd4.putString("a", val_tv4);
                bd4.putString("user_id", newString);
                intent.putExtras(bd4);
                startActivity(intent);
            }
        });
        cd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val_tv5 = tv5.getText().toString();
                Bundle bd5 = new Bundle();
                Intent intent = new Intent(cardview.this, select.class);

                bd5.putString("a", val_tv5);
                bd5.putString("user_id", newString);
                intent.putExtras(bd5);
                startActivity(intent);
            }
        });
        cd6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val_tv6 = tv6.getText().toString();
                Bundle bd6 = new Bundle();
                Intent intent = new Intent(cardview.this, select.class);

                bd6.putString("a", val_tv6);
                bd6.putString("user_id", newString);
                intent.putExtras(bd6);
                startActivity(intent);

            }
        });
        cd7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val_tv7 = tv7.getText().toString();
                Bundle bd7 = new Bundle();
                Intent intent = new Intent(cardview.this, select.class);

                bd7.putString("a", val_tv7);
                bd7.putString("user_id", newString);
                intent.putExtras(bd7);
                startActivity(intent);

            }
        });
        cd8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val_tv8 = tv8.getText().toString();
                Bundle bd8 = new Bundle();
                Intent intent = new Intent(cardview.this, select.class);

                bd8.putString("a", val_tv8);
                bd8.putString("user_id", newString);
                intent.putExtras(bd8);
                startActivity(intent);
            }
        });
        cd9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val_tv9 = tv9.getText().toString();
                Bundle bd9 = new Bundle();
                Intent intent = new Intent(cardview.this, select.class);
                bd9.putString("a", val_tv9);
                bd9.putString("user_id", newString);
                intent.putExtras(bd9);
                startActivity(intent);

            }
        });

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
//            Intent intent = new Intent(cardview.this,map.class);
//            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
