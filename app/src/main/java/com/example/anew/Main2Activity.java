package com.example.anew;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.internal.NavigationMenu;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
//NavigationMenu nav_Profie, nav_add_req,nav_man_req,nav_cpass,nav_feed,nav_logout;


    String newString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);




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



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override


    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();

        if (id == R.id.nav_Profie) {
            // Handle the camera action
        } else if (id == R.id.nav_add_req) {

                    Bundle bd1 = new Bundle();
                    Intent intent = new Intent(Main2Activity.this, cardview.class);
                    bd1.putString("user_id", newString);
                    intent.putExtras(bd1);
                    startActivity(intent);

        } else if (id == R.id.nav_man_req) {
            Bundle bd1 = new Bundle();
            Intent intent = new Intent(Main2Activity.this, user_request.class);
            bd1.putString("user_id", newString);
            intent.putExtras(bd1);
            startActivity(intent);
        } else if (id == R.id.nav_cpass) {

            Bundle bd1 = new Bundle();
            Intent intent = new Intent(Main2Activity.this, user_cpw.class);
            bd1.putString("user_id", newString);
            intent.putExtras(bd1);
            startActivity(intent);
        } else if (id == R.id.nav_feed) {

            Intent intent = new Intent(Main2Activity.this, feedback.class);
            startActivity(intent);

        } else if (id == R.id.nav_logout) {
            Intent intent = new Intent(Main2Activity.this, login.class);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
  }
}
