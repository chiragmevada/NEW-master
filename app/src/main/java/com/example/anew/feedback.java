package com.example.anew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class feedback extends AppCompatActivity {
EditText etfeed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);


        etfeed = (EditText) findViewById(R.id.etfeed);

        etfeed.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                etfeed.setText("");
                return true;

            }

        });


    }
}
