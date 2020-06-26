package com.example.anew;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
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

import java.util.HashMap;
import java.util.Map;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class servicesignup extends AppCompatActivity implements View.OnClickListener {

    TextInputLayout tvl2, tvl3, tvl4;
    EditText etsphone, etspw, etsemail;
    Button btnssignup;
    TextView tvlssignup, tvsalready;
    Switch ssw2;

    public static final String categorynamearray = "category_name";
    public static final String JSON_ARRAY = "result";
    private JSONArray result;
    Spinner spinner;
    String category_name;
    private ArrayList<String> arrayList;
    String category;

    String UpperCaseRegex = ".*[A-Z].*";
    String LowerCaseRegex = ".*[a-z].*";
    String SpecialCharRegex = ".*[@#$%^.&+=].*";
    String NumberRegex = ".*[0-9].*";

    //private String selectedcategory="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicesignup);

        ssw2 = (Switch) findViewById(R.id.ssw2);
        etsphone = (EditText) findViewById(R.id.etsphone);
        etsemail = (EditText) findViewById(R.id.etsemail);
        etspw = (EditText) findViewById(R.id.etspw);

        tvl2 = (TextInputLayout) findViewById(R.id.tvl2);
        tvl3 = (TextInputLayout) findViewById(R.id.tvl3);
        tvl4 = (TextInputLayout) findViewById(R.id.tvl4);
        btnssignup = (Button) findViewById(R.id.btnssignup);

        tvlssignup = (TextView) findViewById(R.id.tvlssignup);
        tvsalready = (TextView) findViewById(R.id.tvsalready);

        Spinner spinner = (Spinner) findViewById(R.id.spservice);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.main_cat, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                category = parent.getItemAtPosition(position).toString();
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnssignup.setOnClickListener(this);


        etspw.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                etspw.setText("");
                return true;

            }

        });

        etsphone.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                etsphone.setText("");
                return true;

            }

        });
        etsemail.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                etsemail.setText("");
                return true;

            }

        });


        tvlssignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(servicesignup.this, servicelogin.class);
                startActivity(intent);
                finish();
            }
        });
        tvsalready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(servicesignup.this, servicelogin.class);
                startActivity(intent);
                finish();

            }
        });
        ssw2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(servicesignup.this, termscondition.class);
                startActivity(intent);

            }
        });
    }


    private void registerUser() {
        String Url = "http://getconnected.edithlink.space/postwebservice.php";

        final String cat = category.trim();
        final String s_p_phone = etsphone.getText().toString().trim();
        final String s_p_email = etsemail.getText().toString().trim();
        final String password = etspw.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String res = "already";
                        String res1 = "no";
                        if (response.matches(res1)) {
                            Toast.makeText(servicesignup.this, "Sorry, an error occurred!", Toast.LENGTH_SHORT).show();
                        } else if (response.matches(res)) {
                            Toast.makeText(servicesignup.this, "Sorry, email already exist!", Toast.LENGTH_SHORT).show();
                        } else {
                            Intent intent = new Intent(servicesignup.this, provider_panel.class);
                            Bundle bd1 = new Bundle();
                            bd1.putString("user_id", response);
                            intent.putExtras(bd1);
                            startActivity(intent);
                            finish();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(servicesignup.this, "Fail", Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();

                params.put("apiname", "RegisterServiceProvider");
                params.put("emailid", s_p_email);
                params.put("phoneno", s_p_phone);
                params.put("category", cat);
                params.put("full_address", "add");
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
            case R.id.btnssignup:
                String Email = etsemail.getText().toString().trim();
                String pass = etspw.getText().toString().trim();
                String phn = etsphone.getText().toString().trim();


                if (TextUtils.isEmpty(phn)) {
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
                } else if (!pass.matches(UpperCaseRegex)) {
                    tvl4.setError(" ");
                    Toast.makeText(this, "Add one uppercase character in password", Toast.LENGTH_SHORT).show();
                } else if (!pass.matches(LowerCaseRegex)) {
                    tvl4.setError(" ");
                    Toast.makeText(this, "Add one lowercase character in password", Toast.LENGTH_SHORT).show();
                } else if (!pass.matches(SpecialCharRegex)) {
                    tvl4.setError(" ");
                    Toast.makeText(this, "Add one special character in password in password", Toast.LENGTH_SHORT).show();
                } else if (!pass.matches(NumberRegex)) {
                    tvl4.setError(" ");
                    Toast.makeText(this, "Add one number in password",
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
