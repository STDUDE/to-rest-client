package com.travel.torest.network.address;

import android.util.Log;

import com.travel.torest.localstorage.CacheService;
import com.travel.torest.localstorage.MessageService;
import com.travel.torest.model.City;
import com.travel.torest.model.Country;
import com.travel.torest.model.arrays.CitiesArray;
import com.travel.torest.model.arrays.CountriesArray;
import com.travel.torest.network.Request;
import com.travel.torest.network.ServerConnect;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Antony on 05.05.2016.
 */
@EBean
public class CitiesRequest implements Request {
    private static final String TAG = "STDude";
    private static final String REQUEST = "req";
    private static final String RESPONSE = "resp";
    private static final String URL = "cities";

    @Bean
    ServerConnect serverConnect;

    @Bean
    CitiesArray cities;

    @Bean
    MessageService cache;

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
        try {
            JSONObject resp = new JSONObject(serverConnect.getResponse());
            JSONArray body = (JSONArray) resp.get("body");
            cities.clear();
            for(int i = 0; i < body.length(); i++){
                Log.i(TAG, "id: " + body.getJSONObject(i).getInt("id") + " country: " + body.getJSONObject(i).getString("country"));
                cities.add(new City(body.getJSONObject(i).getInt("id"), body.getJSONObject(i).getString("city"), null));
                Log.i(TAG, "INIT CITIES ++" + cities.get(i).getCity());
            }

        } catch (JSONException e) {
            cache.setError("Ошибка чтения данных");
            e.printStackTrace();
        }
    }
}
