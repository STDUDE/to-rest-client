package com.travel.torest.fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.travel.torest.R;
import com.travel.torest.localstorage.CacheService;
import com.travel.torest.localstorage.MessageService;
import com.travel.torest.model.Country;
import com.travel.torest.model.Tour;
import com.travel.torest.model.arrays.CountriesArray;
import com.travel.torest.model.arrays.ToursArray;
import com.travel.torest.network.Request;
import com.travel.torest.network.RequestCreator;
import com.travel.torest.network.address.CountriesRequestCreator;
import com.travel.torest.utils.countries.CountriesListAdapter;
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
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.json.JSONException;

@EFragment(R.layout.fragment_hot_tours)
public class HotToursFragment extends Fragment {

    private static String TAG = "STDude";

    ProgressDialog progressDialog;

    @ViewById(R.id.HotToursCountriesList)
    ListView countriesList;

    @Bean
    CountriesListAdapter adapter;

    @Bean
    CountriesArray countries;

    @Bean
    CountriesRequestCreator countriesRequestCreator;

    @Bean
    MessageService message;

    @AfterViews
    protected void init(){
        Log.i(TAG, "init fragment");
        progressDialog = ProgressDialog.show(getContext(), getString(R.string.standby_mode),
                "Загрузка списка стран", true);
        initCountriesArray();
    }

    @ItemClick(R.id.HotToursCountriesList)
    void hotCountriesListItemClicked(Country country) {
        Log.i(TAG, "user clicked on list item");
    }

    @Background
    void initCountriesArray() {
        RequestCreator requestCreator = countriesRequestCreator;
        Request request = requestCreator.ConcreteRequestCreator();
        try {
            Log.i(TAG, "CLIENT GENERATE REQUEST COUNTRIES");
            request.GenerateRequest();
            if(request.GetResponse()) {
                request.ParseResponse();
                success();
            }
            else {
                failed();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @UiThread
    void success() {
        progressDialog.hide();
        countriesList.setAdapter(adapter);

    }

    @UiThread
    void failed() {
        progressDialog.hide();
        Toast toast = Toast.makeText(getContext(), message.getError(), Toast.LENGTH_LONG);
        toast.show();
    }
}
