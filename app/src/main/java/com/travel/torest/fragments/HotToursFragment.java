package com.travel.torest.fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.travel.torest.R;
import com.travel.torest.model.Tour;
import com.travel.torest.model.arrays.CountriesArray;
import com.travel.torest.model.arrays.ToursArray;
import com.travel.torest.utils.hotcountries.HotCountriesListAdapter;
import com.travel.torest.utils.hottours.HotToursListAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_hot_tours)
public class HotToursFragment extends Fragment {

    private static String TAG = "STDude";

    ProgressDialog progressDialog;

    @ViewById(R.id.HotToursCountriesList)
    ListView hotHoursCountriesList;

    @Bean
    HotCountriesListAdapter adapter;

    @Bean
    CountriesArray countries;

    @AfterViews
    protected void init(){
        Log.i(TAG, "init fragment");
        progressDialog = ProgressDialog.show(getContext(), getString(R.string.standby_mode),
                "Загрузка списка туристов", true);
        initTouristsArray();
        hotHoursCountriesList.setAdapter(adapter);
        progressDialog.hide();
    }

    @ItemClick(R.id.HotToursCountriesList)
    void hotCountriesListItemClicked(Tour tour) {
        Log.i(TAG, "user clicked on list item");
    }

    @Background
    void initTouristsArray() {


    }
}
