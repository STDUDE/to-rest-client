package com.travel.torest.screens;

import android.app.ProgressDialog;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;

import com.travel.torest.R;
import com.travel.torest.model.arrays.CountriesArray;
import com.travel.torest.model.Country;
import com.travel.torest.network.Request;
import com.travel.torest.network.RequestCreator;
import com.travel.torest.network.address.CountriesRequest;
import com.travel.torest.network.address.CountriesRequestCreator;
import com.travel.torest.utils.countries.CountriesListAdapter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;
import org.json.JSONException;

@EActivity(R.layout.activity_countries)
public class CountriesActivity extends AppCompatActivity {

    private static String TAG = "STDude";
    public final String URL = "countries";

    ProgressDialog progressDialog;

    @ViewById(R.id.toolbar)
    Toolbar toolbar;

    @ViewById(R.id.CountriesList)
    ListView countriesList;

    @Bean
    CountriesListAdapter adapter;

    @Bean
    CountriesArray countries;

    @Bean
    CountriesRequestCreator countriesRequestCreator;

    @ItemClick(R.id.CountriesList)
    void countryListItemClicked(Country country) {
        Log.i(TAG, "user clicked on list item");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @AfterViews
    protected void bindActionBar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.to_rest);
        getSupportActionBar().setTitle(R.string.title_activity_countries);
        progressDialog = ProgressDialog.show(this, getString(R.string.standby_mode),
                "", true);
        initCountriesArray();
        progressDialog.hide();
        countriesList.setAdapter(adapter);
    }

    @Background
    void initCountriesArray(){
        RequestCreator requestCreator = countriesRequestCreator;
        Request request = requestCreator.ConcreteRequestCreator();
        try {
            Log.i(TAG, "CLIENT GENERATE REQUEST COUNTRIES");
            request.GenerateRequest();
            Log.i(TAG, "CLIENT WILL SEND REQUEST COUNTRIES");
            request.GetResponse();
            Log.i(TAG, "CLIENT GET RESPONCE COUNTRIES");
           /* if(request.GetResponse())

                request.ParseResponse();
            else {
                Log.i(TAG, "2222222222222222222");
            }*/
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
