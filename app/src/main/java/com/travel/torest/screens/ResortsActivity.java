package com.travel.torest.screens;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.travel.torest.R;
import com.travel.torest.localstorage.CacheService;
import com.travel.torest.localstorage.MessageService;
import com.travel.torest.model.Resort;
import com.travel.torest.model.arrays.ResortsArray;
import com.travel.torest.network.Request;
import com.travel.torest.network.RequestCreator;
import com.travel.torest.network.address.ResortsRequestCreator;
import com.travel.torest.utils.resorts.ResortsListAdapter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.json.JSONException;

@EActivity(R.layout.activity_resorts)
public class ResortsActivity extends AppCompatActivity {

    private static String TAG = "STDude";
    public final String URL = "resorts";

    ProgressDialog progressDialog;

    @ViewById(R.id.toolbar)
    Toolbar toolbar;

    @ViewById(R.id.ResortsList)
    ListView resortsList;

    @Bean
    ResortsListAdapter adapter;

    @Bean
    MessageService message;

    @Bean
    ResortsArray resorts;

    @Bean
    ResortsRequestCreator resortsRequestCreator;

    @ItemClick(R.id.ResortsList)
    void cityListItemClicked(Resort resort) {
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
        getSupportActionBar().setTitle(R.string.title_activity_resorts);
        progressDialog = ProgressDialog.show(this, getString(R.string.standby_mode),
                "Загрузка списка списка курортов", true);
        initCitiesArray();
    }

    @Background
    void initCitiesArray(){
        RequestCreator requestCreator = resortsRequestCreator;
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
        resortsList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        resortsList.setAdapter(adapter);

    }

    @UiThread
    void failed() {
        progressDialog.hide();
        Toast toast = Toast.makeText(this, message.getError(), Toast.LENGTH_LONG);
        toast.show();
        NavUtils.navigateUpFromSameTask(this);
    }
}
