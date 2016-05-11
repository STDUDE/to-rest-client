package com.travel.torest.network.sendings;

import android.util.Log;

import com.travel.torest.localstorage.CacheService;
import com.travel.torest.localstorage.MessageService;
import com.travel.torest.network.Request;
import com.travel.torest.network.ServerConnect;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Antony on 10.05.2016.
 */
@EBean
public class SendEmailRequest implements Request {
    private static final String TAG = "STDude";
    private static final String REQUEST = "req";
    private static final String RESPONSE = "resp";
    private static final String URL = "send/email";
    private static final String DESCRIPTION = "description";
    private static final String PHONE = "phone";
    private static final String EMAIL = "email";

    @Bean
    CacheService cache;

    @Bean
    MessageService message;

    @Bean
    ServerConnect serverConnect;

    @Override
    public void GenerateRequest() throws JSONException {
        Log.i(TAG, "generate request " + URL);
        JSONObject dataToServer = new JSONObject();
        dataToServer.put(REQUEST, EMAIL);
        dataToServer.put(DESCRIPTION, cache.getDescription());
        dataToServer.put(PHONE, cache.getPhone());
        dataToServer.put(EMAIL, cache.getEmail());
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
            String infoMessage = resp.getString("message");
            message.setInfo(infoMessage);
        } catch (JSONException e) {
            message.setError("Ошибка чтения данных");
            e.printStackTrace();
        }
    }
}
