package com.example.anew;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class login extends AppCompatActivity implements View.OnClickListener {
    Button btnlogin;
    TextView tvllogin, tvdont;
    TextView tvforgot;
    TextInputEditText etphone1, etpw1;
    TextInputLayout textInputLayout, tvl;

    String UpperCaseRegex = ".*[A-Z].*";
    String LowerCaseRegex = ".*[a-z].*";
    String SpecialCharRegex = ".*[@#$%^.&+=].*";
    String NumberRegex = ".*[0-9].*";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnlogin = (Button) findViewById(R.id.btnlogin);
        tvllogin = (TextView) findViewById(R.id.tvllogin);
        tvforgot = (TextView) findViewById(R.id.tvforgot);
        tvdont = (TextView) findViewById(R.id.tvdont);
        etphone1 = (TextInputEditText) findViewById(R.id.etphone1);
        etpw1 = (TextInputEditText) findViewById(R.id.etpw1);
        textInputLayout = (TextInputLayout) findViewById(R.id.tvl2);
        tvl = (TextInputLayout) findViewById(R.id.tvl);

        btnlogin.setOnClickListener(this);

        tvllogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, signup.class);
                startActivity(intent);
                finish();
            }
        });
        tvdont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, signup.class);
                startActivity(intent);

            }
        });
        tvforgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, forgot.class);
                startActivity(intent);
                finish();
            }
        });

        etpw1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                etpw1.setText("");
                return true;

            }

        });

        etphone1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                etphone1.setText("");
                return true;

            }

        });
    }

    private void registerUser() {
        String Url = "http://getconnected.edithlink.space/postwebservice.php";

        final String phone = etphone1.getText().toString().trim();
        final String password = etpw1.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject obj = new JSONObject(response);
                            if (obj.getBoolean("IsSuccess")) {
                                Log.e("respose",obj.toString());
                                Intent intent = new Intent(login.this, cardview.class);

                                Bundle bd1 = new Bundle();
                                bd1.putString("user_id", obj.getJSONArray("Data").getString(0));
                                intent.putExtras(bd1);

                                startActivity(intent);
                                finish();

                            } else {
                                Toast.makeText(login.this, "Sorry, Authentication Fail!", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("response", error.getMessage());
                        Log.v("response", error.getMessage());
                        Toast.makeText(login.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                })
//        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
//                DefaultRetryPolicy.DEFAULT_TIMEOUT_MS,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//
//
        {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("apiname", "UserLogin");
                params.put("phoneno", phone);
                params.put("password", password);
                return params;

            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnlogin:
                String pass = etpw1.getText().toString().trim();
                String phn = etphone1.getText().toString().trim();


                if (TextUtils.isEmpty(phn)) {
                    tvl.setError(" ");
                    Toast.makeText(this, "Enter phone number", Toast.LENGTH_SHORT).show();
                } else if ((phn.length() != 10)) {
                    tvl.setError(" ");
                    Toast.makeText(this, "Phone number must be 10 digit number",
                            Toast.LENGTH_SHORT).show();
                } else if (!phn.matches(NumberRegex)) {
                    tvl.setError(" ");
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
