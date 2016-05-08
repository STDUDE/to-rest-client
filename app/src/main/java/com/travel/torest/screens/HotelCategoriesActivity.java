package com.travel.torest.screens;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;

import com.travel.torest.R;
import com.travel.torest.model.arrays.HotelCategoriesArray;
import com.travel.torest.network.Request;
import com.travel.torest.network.RequestCreator;
import com.travel.torest.network.address.HotelsRequestCreator;
import com.travel.torest.utils.hotelcategories.HotelCategoriesListAdapter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;
import org.json.JSONException;

@EActivity(R.layout.activity_hotel_categories)
public class HotelCategoriesActivity extends AppCompatActivity {
    private static String TAG = "STDude";
    public final String URL = "categories";

    ProgressDialog progressDialog;

    @ViewById(R.id.toolbar)
    Toolbar toolbar;

    @ViewById(R.id.HotelCategoriesList)
    ListView categoriesList;

    @Bean
    HotelCategoriesListAdapter adapter;

    @Bean
    HotelsRequestCreator hotelsRequestCreator;

    @ItemClick(R.id.HotelCategoriesList)
    void countryListItemClicked(Integer category) {
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
        getSupportActionBar().setTitle(R.string.title_activity_holtel_categories);
        categoriesList.setAdapter(adapter);
    }

    @Background
    void initCategoriesArray(){
        RequestCreator requestCreator = hotelsRequestCreator;
        Request request = requestCreator.ConcreteRequestCreator();
        try {
            request.GenerateRequest();
            if(request.GetResponse())
                request.ParseResponse();
            else {
                Log.i(TAG, "2222222222222222222");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
