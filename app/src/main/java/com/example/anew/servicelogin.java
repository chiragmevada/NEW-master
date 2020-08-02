package com.example.anew;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class servicelogin extends AppCompatActivity implements View.OnClickListener {
    Button btnslogin;
    TextView tvlslogin, stvdont;
    TextView tvsforgot;
    TextInputEditText etsphone1, etspw1;
    TextInputLayout textInputLayout, tvl1;

    String UpperCaseRegex = ".*[A-Z].*";
    String LowerCaseRegex = ".*[a-z].*";
    String SpecialCharRegex = ".*[@#$%^.&+=].*";
    String NumberRegex = ".*[0-9].*";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicelogin);

        btnslogin = (Button) findViewById(R.id.btnslogin);
        tvlslogin = (TextView) findViewById(R.id.tvlslogin);
        tvsforgot = (TextView) findViewById(R.id.tvsforgot);
        stvdont = (TextView) findViewById(R.id.stvdont);
        etsphone1 = (TextInputEditText) findViewById(R.id.etsphone1);
        etspw1 = (TextInputEditText) findViewById(R.id.etspw1);
        textInputLayout = (TextInputLayout) findViewById(R.id.tvl1);
        tvl1 = (TextInputLayout) findViewById(R.id.tvl);

        btnslogin.setOnClickListener(this);

        tvlslogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(servicelogin.this, servicesignup.class);
                startActivity(intent);
                finish();
            }
        });
        stvdont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(servicelogin.this, servicesignup.class);
                startActivity(intent);

            }
        });
        tvsforgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(servicelogin.this, serviceforgot.class);
                startActivity(intent);
                finish();
            }
        });

        etspw1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                etspw1.setText("");
                return true;

            }

        });

        etsphone1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                etsphone1.setText("");
                return true;

            }

        });

    }

//    private void registerUser() {
//        String Url = "http://getconnected.edithlink.space/postwebservice.php";
//
//        final String sphone = etsphone1.getText().toString().trim();
//        final String spassword = etspw1.getText().toString().trim();
//
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, Url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        String result = response.toString();
//                        String res = "no";
//                        if (result.matches(res)) {
//                            Toast.makeText(servicelogin.this, "Sorry, Authentication Fail!", Toast.LENGTH_SHORT).show();
//                        } else {
//
//                            Intent intent = new Intent(servicelogin.this, provider_panel.class);
//
//                            Bundle bd1 = new Bundle();
//                            bd1.putString("user_id", result);
//                            intent.putExtras(bd1);
//
//                            startActivity(intent);
//                            finish();
//
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(servicelogin.this, "Fail", Toast.LENGTH_SHORT).show();
//                    }
//                }) {
//            @Override
//            protected Map<String, String> getParams() {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("apiname", "ServiceProviderLogin");
//                params.put("phoneno", sphone);
//                params.put("password", spassword);
//                return params;
//
//            }
//        };
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        requestQueue.add(stringRequest);
//    }

    private void registerUser() {
        String Url = "http://192.168.43.234/awarenes/service_login.php";

        final String sphone = etsphone1.getText().toString().trim();
        final String spassword = etspw1.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String result = response.toString();
                        String res = "no";
                        if (result.matches(res)) {
                            Toast.makeText(servicelogin.this, "Sorry, Authentication Fail!", Toast.LENGTH_SHORT).show();
                        } else {

                            Intent intent = new Intent(servicelogin.this, provider_panel.class);

                            Bundle bd1 = new Bundle();
                            bd1.putString("user_id", result);
                            intent.putExtras(bd1);

                            startActivity(intent);
                            finish();

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(servicelogin.this, "Fail", Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Lphone", sphone);
                params.put("Lpassword", spassword);
                return params;

            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnslogin:
                String pass = etspw1.getText().toString().trim();
                String phn = etsphone1.getText().toString().trim();

                if (TextUtils.isEmpty(phn)) {
                    tvl1.setError(" ");
                    Toast.makeText(this, "Enter phone number", Toast.LENGTH_SHORT).show();
                } else if ((phn.length() != 10)) {
                    tvl1.setError(" ");
                    Toast.makeText(this, "Phone number must be 10 digit number",
                            Toast.LENGTH_SHORT).show();
                } else if (!phn.matches(NumberRegex)) {
                    tvl1.setError(" ");
                    Toast.makeText(this, "phone number must be number not character",
                            Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(pass)) {
                    textInputLayout.setError(" ");
                    Toast.makeText(this, "Enter password",
                            Toast.LENGTH_SHORT).show();
                } else if (!pass.matches(UpperCaseRegex)) {
                    textInputLayout.setError(" ");
                    Toast.makeText(this, "Add one uppercase character in password", Toast.LENGTH_SHORT).show();
                } else if (!pass.matches(LowerCaseRegex)) {
                    textInputLayout.setError(" ");
                    Toast.makeText(this, "Add one lowercase character in password", Toast.LENGTH_SHORT).show();
                } else if (!pass.matches(SpecialCharRegex)) {
                    textInputLayout.setError(" ");
                    Toast.makeText(this, "Add one special character in password in password", Toast.LENGTH_SHORT).show();
                } else if (!pass.matches(NumberRegex)) {
                    textInputLayout.setError(" ");
                    Toast.makeText(this, "Add one number in password",
                            Toast.LENGTH_SHORT).show();
                } else if (pass.length() <= 6) {
                    textInputLayout.setError(" ");
                    Toast.makeText(this, "password should be more than 6 chars", Toast.LENGTH_SHORT).show();
                } else {
                    registerUser();
                }
                break;
        }
    }
}