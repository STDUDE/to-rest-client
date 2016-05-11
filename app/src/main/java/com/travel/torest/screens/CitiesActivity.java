package com.travel.torest.screens;

import android.app.ProgressDialog;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.travel.torest.R;
import com.travel.torest.localstorage.CacheService;
import com.travel.torest.localstorage.MessageService;
import com.travel.torest.model.arrays.CitiesArray;
import com.travel.torest.model.City;
import com.travel.torest.network.Request;
import com.travel.torest.network.RequestCreator;
import com.travel.torest.network.address.CitiesRequest;
import com.travel.torest.network.address.CitiesRequestCreator;
import com.travel.torest.utils.cities.CitiesListAdapter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.json.JSONException;

@EActivity(R.layout.activity_cities)
public class CitiesActivity extends AppCompatActivity {

    private static String TAG = "STDude";
    public final String URL = "cities";

    ProgressDialog progressDialog;

    @ViewById(R.id.toolbar)
    Toolbar toolbar;

    @ViewById(R.id.CitiesList)
    ListView citiesList;

    @Bean
    CitiesListAdapter adapter;

    @Bean
    MessageService message;

    @Bean
    CitiesArray cities;

    @Bean CitiesRequestCreator citiesRequestCreator;

    @ItemClick(R.id.CitiesList)
    void cityListItemClicked(City city) {
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
        getSupportActionBar().setTitle(R.string.title_activity_cities);
        progressDialog = ProgressDialog.show(this, getString(R.string.standby_mode),
                "Загрузка списка городов", true);
        initCitiesArray();
    }

    @Background
    void initCitiesArray(){
        RequestCreator requestCreator = citiesRequestCreator;
        Request request = requestCreator.ConcreteRequestCreator();
        try {
            Log.i(TAG, "CLIENT GENERATE REQUEST CITIES");
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
        citiesList.setAdapter(adapter);
    }

    @UiThread
    void failed() {
        progressDialog.hide();
        Toast toast = Toast.makeText(this, message.getError(), Toast.LENGTH_LONG);
        toast.show();
        NavUtils.navigateUpFromSameTask(this);
    }
}
