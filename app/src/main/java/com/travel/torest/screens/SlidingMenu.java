package com.travel.torest.screens;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.travel.torest.R;
import com.travel.torest.fragments.*;

import org.androidannotations.annotations.Click;

public class SlidingMenu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "STDude";
    NavigationView navigationView = null;

    Toolbar toolbar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "start creation SLIDING MENU ACTIVITY");
        setContentView(R.layout.activity_sliding_menu);
        toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.to_rest);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        if (drawer != null)
        {
            drawer.setDrawerListener(toggle);
        }
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
        }
        onClickInfo();
        Log.i(TAG, "end creation SLIDING MENU ACTIVITY");
    }

    @Override
    public void onBackPressed() {
        Log.i(TAG, "user clicked BACK");
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer != null && drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sliding_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Log.i(TAG, "user clicked on OPTIONS ITEM");
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Log.i(TAG, "user clicked on MENU ITEM");

        switch (item.getItemId()){
            case R.id.nav_orders:
                onClickOrders();
                break;
            case R.id.nav_hottours:
                onClickHotTours();
                break;
            case R.id.nav_search:
                onClickSearchTour();
                break;
            case R.id.nav_history:
                onClickHistory();
                break;
            case R.id.nav_man:
                onClickTourists();
                break;
            case R.id.nav_request:
                onClickSearchRequest();
                break;
            case R.id.nav_info:
                onClickInfo();
                break;
            case R.id.nav_share:
                break;
            case R.id.nav_send:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer != null) {
            drawer.closeDrawer(GravityCompat.START);
        }
        return true;
    }

    protected void onClickOrders() {
        Log.i(TAG, "user clicked ORDERS");
        OrdersFragment fragment = new OrdersFragment_();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_content, fragment);
        fragmentTransaction.commit();
    }

    protected void onClickHotTours() {
        Log.i(TAG, "user clicked HOT TOURS");
        HotToursFragment fragment = new HotToursFragment_();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_content, fragment);
        fragmentTransaction.commit();
    }

    protected void onClickSearchTour() {
        Log.i(TAG, "user clicked SEARCH TOUR");
        SearchTourFragment fragment = new SearchTourFragment_();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_content, fragment);
        fragmentTransaction.commit();
    }

    protected void onClickHistory() {
        Log.i(TAG, "user clicked HISTORY");
        HistoryFragment fragment = new HistoryFragment_();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_content, fragment);
        fragmentTransaction.commit();
    }

    protected void onClickTourists() {
        Log.i(TAG, "user clicked TOURISTS");
        TouristsFragment fragment = new TouristsFragment_();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_content, fragment);
        fragmentTransaction.commit();
    }

    protected void onClickSearchRequest() {
        Log.i(TAG, "user clicked on REQUEST SEARCH");
        RequestForSearchFragment fragment = new RequestForSearchFragment_();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_content, fragment);
        fragmentTransaction.commit();
    }

    protected void onClickInfo() {
        Log.i(TAG, "user clicked INFO");
        InfoFragment fragment = new InfoFragment_();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_content, fragment);
        fragmentTransaction.commit();

    }
}

