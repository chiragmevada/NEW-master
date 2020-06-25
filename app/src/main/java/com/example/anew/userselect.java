package com.example.anew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class userselect extends AppCompatActivity {

    String finalResult;
    HashMap<String, String> hashMap = new HashMap<>();
    String HttpURL_1 = "http://192.168.0.177/awarenes/json_category.php";
    Usercomment_adapter adapter;
    JSONArray data = new JSONArray();
    RecyclerView recyclerView;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userselect);

        txt = (TextView) findViewById(R.id.uid);
        final String newString;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                newString = null;
            } else {
                newString = extras.getString("user_id");
                txt.setText(newString);
            }
        } else {
            newString = (String) savedInstanceState.getSerializable("STRING_I_NEED");
        }

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        get_review();
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));

    }
    private void get_review() {


        RequestQueue queue = Volley.newRequestQueue(userselect.this);
        // prepare the Request
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.POST, HttpURL_1, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // display response
//                        Log.d("Msg", String.valueOf(response));
//                        Log.e(TAG, "reviewResponse===>" + response);
                        try {
                            int status = response.getInt("status");
                            if (status == 1) {
                                JSONArray data_new = response.getJSONArray("data");
                                int count = data_new.length();
//                                Log.e(TAG, "count===>" + count);

                                for (int i = 0; i < data_new.length(); i++) {
                                    data.put(data_new.get(i));
                                }
                                if (adapter == null) {
                                    adapter = new Usercomment_adapter(userselect.this, data);
                                    recyclerView.setAdapter(adapter);
                                } else {
                                    adapter.notifyDataSetChanged();
                                }


                            } else {

                                //Toast.makeText(Activity_Gov_facilities.this, "No Data Found", Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", error.toString());

                    }
                }
        );

        // add it to the RequestQueue
        queue.add(getRequest);
    }

}
