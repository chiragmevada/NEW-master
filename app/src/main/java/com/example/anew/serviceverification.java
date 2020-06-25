package com.example.anew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class serviceverification extends AppCompatActivity implements TextWatcher {
    Button btnslogin;
    EditText set1, set2, set3, set4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serviceverification);

        btnslogin = (Button) findViewById(R.id.btnslogin);

        set1 = (EditText) findViewById(R.id.set1);
        set2 = (EditText) findViewById(R.id.set2);
        set3 = (EditText) findViewById(R.id.set3);
        set4 = (EditText) findViewById(R.id.set4);

        set1.addTextChangedListener((TextWatcher) this);
        set2.addTextChangedListener((TextWatcher) this);
        set3.addTextChangedListener((TextWatcher) this);
        set4.addTextChangedListener((TextWatcher) this);
        btnslogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(serviceverification.this, map.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (s.length() == 1) {
            if (set1.length() == 1) {
                set2.requestFocus();
            }
            if (set2.length() == 1) {
                set3.requestFocus();
            }
            if (set3.length() == 1) {
                set4.requestFocus();
            }


        }
    }
}
