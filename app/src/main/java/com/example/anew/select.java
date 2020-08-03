package com.example.anew;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class select extends AppCompatActivity {

    TextView txt;
    ImageView cameraImg, pickImage;
    Button btnuserreq;

    ArrayList<String> cityNameList = new ArrayList<>();
    ArrayList<String> cityIdList = new ArrayList<>();

    ArrayList<String> areaNameList = new ArrayList<>();
    ArrayList<String> areaIdList = new ArrayList<>();

    Spinner spinnerArea;
    Spinner spinnerCity;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        loadCityData("http://skysparrow.in/project_api/awearness/api_getcity.php");

        txt = (TextView) findViewById(R.id.cat_txt);
        cameraImg = (ImageView) findViewById(R.id.cameraIcon);
        pickImage = (ImageView) findViewById(R.id.pickImage);
        btnuserreq = (Button) findViewById(R.id.btnuserreq);

        spinnerArea = (Spinner) findViewById(R.id.spAres);
        spinnerCity = (Spinner) findViewById(R.id.spCity);

        spinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                int index = spinnerCity.getSelectedItemPosition();
                loadAreaData("http://skysparrow.in/project_api/awearness/api_getarea.php", cityIdList.get(index));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        spinnerArea.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String area = spinnerArea.getItemAtPosition(spinnerArea.getSelectedItemPosition()).toString();
                Toast.makeText(getApplicationContext(), area, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        String newString;
        SharedPreferences sharedpreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
        userId = sharedpreferences.getString("userid", "");

        Bundle bd = getIntent().getExtras();

        newString = bd.getString("a");
        txt.setText(newString);

        cameraImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, 1);
                }
            }
        });

        btnuserreq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bd1 = new Bundle();
                Intent intent = new Intent(select.this, user_my_req.class);
//                bd1.putString("user_id", newString);
                intent.putExtras(bd1);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            pickImage.getLayoutParams().height = 500;
            pickImage.setImageBitmap(imageBitmap);
        }
    }

    private void loadCityData(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    JSONArray jsonArray = jsonObject.getJSONArray("city_data");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        String name = jsonObject1.getString("city_name");
                        String id = jsonObject1.getString("city_id");
                        cityNameList.add(name);
                        cityIdList.add(id);
                    }
                    spinnerCity.setAdapter(new ArrayAdapter<String>(select.this, android.R.layout.simple_spinner_dropdown_item, cityNameList));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        int socketTimeout = 30000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(policy);
        requestQueue.add(stringRequest);
    }

    private void loadAreaData(String url, final String cityId) {
        Toast.makeText(select.this, cityId, Toast.LENGTH_SHORT).show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Intent intent = new Intent(select.this, cardview.class);
                        try {
                            Toast.makeText(select.this, response, Toast.LENGTH_SHORT).show();
                            if (!response.equals("null")) {
                                JSONObject jsonObject = new JSONObject(response);
                                JSONArray jsonArray = jsonObject.getJSONArray("area_data");
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                                    String name = jsonObject1.getString("area_name");
                                    String id = jsonObject1.getString("area_id");
                                    areaNameList.add(name);
                                    areaIdList.add(id);
                                }
                                spinnerArea.setAdapter(new ArrayAdapter<String>(select.this, android.R.layout.simple_spinner_dropdown_item, areaNameList));
                            } else {
                                spinnerArea.setAdapter(null);
                                Toast.makeText(select.this, response, Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(select.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("city_id", cityId);
                return params;

            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
