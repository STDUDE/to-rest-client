package com.travel.torest.network.address;

import android.util.Log;

import com.travel.torest.model.arrays.CountriesArray;
import com.travel.torest.network.Request;
import com.travel.torest.network.ServerConnect;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EApplication;
import org.androidannotations.annotations.EBean;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Antony on 02.05.2016.
 */
@EBean
public class CountriesRequest implements Request{
    private static final String TAG = "STDude";
    private static final String REQUEST = "req";
    private static final String RESPONSE = "resp";
    private static final String URL = "countries";

    @Bean
    ServerConnect serverConnect;

    @Bean
    CountriesArray countries;

    @Override
    public void GenerateRequest() throws JSONException {
        Log.i(TAG, "generate request " + URL);
        JSONObject dataToServer = new JSONObject();
        dataToServer.put(REQUEST, URL);
        serverConnect.setURL(URL);
        serverConnect.setDataToServer(dataToServer.toString());
    }

    @Override
    public boolean GetResponse() throws JSONException {
        Log.i(TAG, "get responce " + URL);
        return serverConnect.testPOST();
    }

    @Override
    public void ParseResponse(){

    }
}
