/*
Author: Clint Davis
Date: 02/23/23

This is my final Capstone Project for the class.
 */

package com.example.capstonefinale;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Initialize the SharedPreferences object
        sharedPreferences = getPreferences(MODE_PRIVATE);

        //display the main menu when the activity is loaded
        displaySelectedScreen(R.id.nav_Main);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the toolbar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

        //calls the method "displaySelectedScreen" and passes the id of selected menu drawer
        displaySelectedScreen(item.getItemId());

        return true;
    }

    private void displaySelectedScreen(int itemId) {

        //creates a fragment object
        Fragment fragment = null;

        //initializes the fragment object which is selected
        switch (itemId) {
            case R.id.nav_Love:
                fragment = new Menu_Love();
                break;
            case R.id.nav_Work:
                fragment = new Menu_Work();
                break;
            case R.id.nav_Learning:
                fragment = new Menu_Learning();
                break;
            case R.id.nav_Play:
                fragment = new Menu_Play();
                break;
            case R.id.nav_Health:
                fragment = new Menu_Health();
                break;
            case R.id.nav_Safety:
                fragment = new Menu_Safety();
                break;
            case R.id.nav_Main:
                fragment = new Menu_Main();
                break;
            case R.id.nav_Summary:
                fragment = new Menu_Summary();
                break;
        }

        //replaces the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }


    // Method to save a string value to the app's SharedPreferences
    public void saveStringToSharedPreferences(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    // Method to retrieve a string value from the app's SharedPreferences
    public String getStringFromSharedPreferences(String key, String defaultValue) {
        return sharedPreferences.getString(key, defaultValue);
    }
}