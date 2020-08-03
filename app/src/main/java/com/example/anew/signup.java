package com.example.anew;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import cz.msebera.android.httpclient.Header;

public class signup extends AppCompatActivity implements View.OnClickListener {
    TextView tvlsignup, tvalready;
    Button btnsignup;
    Switch sw2;
    TextInputLayout tvl1, tvl2, tvl3, tvl4;
    EditText etname, etphone, etpw, etemail;

    String NumberRegex = ".*[0-9].*";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        tvlsignup = (TextView) findViewById(R.id.tvlsignup);

        sw2 = (Switch) findViewById(R.id.sw2);
        tvalready = (TextView) findViewById(R.id.tvalready);
        btnsignup = (Button) findViewById(R.id.btnsignup);
        etname = (EditText) findViewById(R.id.etname);
        etphone = (EditText) findViewById(R.id.etphone);
        etemail = (EditText) findViewById(R.id.etemail);
        etpw = (EditText) findViewById(R.id.etpw);
        tvl1 = (TextInputLayout) findViewById(R.id.tvl1);
        tvl2 = (TextInputLayout) findViewById(R.id.tvl2);
        tvl3 = (TextInputLayout) findViewById(R.id.tvl3);
        tvl4 = (TextInputLayout) findViewById(R.id.tvl4);

        btnsignup.setOnClickListener(this);

        etname.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                etname.setText("");
                return true;

            }

        });
        etpw.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                etpw.setText("");
                return true;

            }

        });

        etphone.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                etphone.setText("");
                return true;

            }

        });
        etemail.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                etemail.setText("");
                return true;

            }

        });


        tvlsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signup.this, login.class);
                startActivity(intent);
                finish();
            }
        });
        tvalready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signup.this, login.class);
                startActivity(intent);
                finish();

            }
        });
        sw2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signup.this, termscondition.class);
                startActivity(intent);
            }
        });
    }

    /*public  void registerUser() {
        if (asyncHttpClient != null) {
            asyncHttpClient.cancelRequests(getApplicationContext(), true);
        }
        asyncHttpClient = new AsyncHttpClient();
        RequestParams requestParams = new RequestParams();
        Log.e("****>", Selected_gender.toString());
        Log.e("****>", current_user);
        requestParams.put("userid", current_user);
        requestParams.put("name", member_name.getT.ext());
        requestParams.put("gender", Selected_gender.getText().toString());
        requestParams.put("dob", passing_DOB);
        requestParams.put("relation", spinner.getSelectedItem().toString());

        asyncHttpClient.post("http://getconnected.edithlink.space/postwebservice.php", requestParams, new myresponse_add_member());
    }

    private class myresponse_add_member extends AsyncHttpResponseHandler
    {
        @Override
        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
            String str=new String(responseBody);
            Log.e("Response----->",str);
            web_add_family_member wb =new Gson().fromJson(str,web_add_family_member.class);
            sweetAlertDialog.dismiss();
            if(wb.response.equals("Register Success"))
            {
                Toast.makeText(getContext(),wb.response,Toast.LENGTH_LONG).show();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.family_member_content,new manage_family_member()).addToBackStack(null).commit();
            }
            else if(wb.response.equals("Fail"))
            {
                Toast.makeText(getContext(),wb.response,Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
        }
    }
*/

//    private void registerUser() {
//        String Url = "http://getconnected.edithlink.space/postwebservice.php";
//        final String name = etname.getText().toString().trim();
//        final String phone = etphone.getText().toString().trim();
//        final String email = etemail.getText().toString().trim();
//        final String password = etpw.getText().toString().trim();
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, Url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        try {
//                            Log.e("1 -->>", "abc" + response);
//                            //JSONObject obj = new JSONObject(response);
//                            //Log.e("-->>",obj.toString());
//                            //Toast.makeText(signup.this, obj.toString(), Toast.LENGTH_SHORT).show();
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                            Log.e("-->>", e.toString());
//                        }
//                        String res = "already";
//                        String res1 = "no";
//                        Intent intent = new Intent(signup.this, cardview.class);
//                        Bundle bd1 = new Bundle();
//                        bd1.putString("user_id", "");
//                        intent.putExtras(bd1);
//                        startActivity(intent);
//                        finish();
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(signup.this, "Fail", Toast.LENGTH_SHORT).show();
//                    }
//                }) {
//            @Override
//            protected Map<String, String> getParams() {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("apiname", "RegisterUser");
//                params.put("uname", name);
//                params.put("emailid", email);
//                params.put("address", "");
//                params.put("city", "1");
//                params.put("phoneno", phone);
//                params.put("password", password);
//                return params;
//            }
//        };
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        requestQueue.add(stringRequest);
//    }

    private void registerUser() {
        String Url = "http://skysparrow.in/project_api/awearness/api_registeruser.php";
        final String name = etname.getText().toString().trim();
        final String phone = etphone.getText().toString().trim();
        final String email = etemail.getText().toString().trim();
        final String password = etpw.getText().toString().trim();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject jsonObject = null;
                        try {
                            jsonObject = new JSONObject(response);
                            String res = jsonObject.getString("Response");
                            if (res.equals("Register Success")) {
                                Intent intent = new Intent(signup.this, view.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(signup.this, "Registration Fail", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(signup.this, "Fail", Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("uname", name);
                params.put("email", email);
                params.put("phone", phone);
                params.put("address", "");
                params.put("city", "");
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
            case R.id.btnsignup:
                String Name = etname.getText().toString().trim();
                String Email = etemail.getText().toString().trim();
                String pass = etpw.getText().toString().trim();
                String phn = etphone.getText().toString().trim();

                if (TextUtils.isEmpty(Name)) {
                    tvl1.setError(" ");
                    Toast.makeText(this, "Enter name", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(phn)) {
                    tvl2.setError(" ");
                    Toast.makeText(this, "Enter phone number", Toast.LENGTH_SHORT).show();
                } else if ((phn.length() != 10)) {
                    tvl2.setError(" ");
                    Toast.makeText(this, "Phone number must be 10 digit number",
                            Toast.LENGTH_SHORT).show();
                } else if (!phn.matches(NumberRegex)) {
                    tvl2.setError(" ");
                    Toast.makeText(this, "phone number must be number not character",
                            Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(Email)) {
                    tvl3.setError(" ");
                    Toast.makeText(this, "Enter email",
                            Toast.LENGTH_SHORT).show();
                } else if (!Utility.isValidEmail(Email)) {
                    tvl3.setError(" ");
                    Toast.makeText(this, "Email is not valid",
                            Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(pass)) {
                    tvl4.setError(" ");
                    Toast.makeText(this, "Enter password",
                            Toast.LENGTH_SHORT).show();
                } else if (pass.length() <= 6) {
                    tvl4.setError(" ");
                    Toast.makeText(this, "password should be more than 6 chars", Toast.LENGTH_SHORT).show();
                } else {
                    registerUser();
                }
                break;
        }
    }
}



