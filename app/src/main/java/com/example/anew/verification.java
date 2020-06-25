package com.example.anew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class verification extends AppCompatActivity implements TextWatcher{
    Button btnlogin;
    EditText et1, et2, et3, et4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        btnlogin=(Button)findViewById(R.id.btnlogin);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        et4 = (EditText) findViewById(R.id.et4);

        et1.addTextChangedListener((TextWatcher) this);
        et2.addTextChangedListener((TextWatcher) this);
        et3.addTextChangedListener((TextWatcher) this);
        et4.addTextChangedListener((TextWatcher) this);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(verification.this,map.class);
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
            if (et1.length() == 1) {
                et2.requestFocus();
            }
            if (et2.length() == 1) {
                et3.requestFocus();
            }
            if (et3.length() == 1) {
                et4.requestFocus();
            }


        }
    }
    }
