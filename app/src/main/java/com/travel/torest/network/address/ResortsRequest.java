package com.travel.torest.network.address;

import android.util.Log;

import com.travel.torest.localstorage.CacheService;
import com.travel.torest.localstorage.MessageService;
import com.travel.torest.model.Resort;
import com.travel.torest.model.arrays.ResortsArray;
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
public class ResortsRequest implements Request {
    private static final String TAG = "STDude";
    private static final String REQUEST = "req";
    private static final String RESPONSE = "resp";
    private static final String URL = "resorts";
    private static final String COUNTRY = "country_id";

    @Bean
    ServerConnect serverConnect;

    @Bean
    CacheService cache;

    @Bean
    MessageService message;

    @Bean
    ResortsArray resorts;

    @Override
    public void GenerateRequest() throws JSONException {
        Log.i(TAG, "generate request " + URL);
        JSONObject dataToServer = new JSONObject();
        dataToServer.put(REQUEST, URL);
        dataToServer.put(COUNTRY, cache.getCache().getCountry_id());
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
            resorts.clear();
            for(int i = 0; i < body.length(); i++){
                Log.i(TAG, "id: " + body.getJSONObject(i).getInt("id") + " country: " + body.getJSONObject(i).getString("country"));
                resorts.add(new Resort(body.getJSONObject(i).getInt("id"), body.getJSONObject(i).getString("city"), null));
                Log.i(TAG, "INIT CITIES ++" + resorts.get(i).getCity());
            }

        } catch (JSONException e) {
            message.setError("Ошибка чтения данных");
            e.printStackTrace();
        }
    }
}
