package com.travel.torest.fragments;



import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.ListView;

import com.travel.torest.R;
import com.travel.torest.model.arrays.TouristsArray;
import com.travel.torest.screens.NewTouristActivity_;
import com.travel.torest.utils.tourists.TouristListAdapter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_tourists)
public class TouristsFragment extends Fragment {

    private static String TAG = "STDude";

    ProgressDialog progressDialog;

    @ViewById(R.id.addTourist)
    FloatingActionButton fab;

    @ViewById(R.id.TouristsList)
    ListView touristsList;

    @Bean
    TouristListAdapter adapter;

    @Bean
    TouristsArray tourists;

    @AfterViews
    protected void init(){
        /*Snackbar.make(getView(), "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();*/
        Log.i(TAG, "init fragment");
        progressDialog = ProgressDialog.show(getContext(), getString(R.string.standby_mode),
                "Загрузка списка туристов", true);
        initTouristsArray();
        touristsList.setAdapter(adapter);
        progressDialog.hide();
    }

    @Click(R.id.addTourist)
    void addTouristFabListener(){
        Intent intent = new Intent(getActivity(), NewTouristActivity_.class);
        startActivity(intent);
    }

    @Background
    void initTouristsArray() {


    }


}
