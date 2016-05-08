package com.travel.torest.network;

import com.travel.torest.network.Request;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Antony on 02.05.2016.
 */
public class DefaultReq implements Request {

    @Override
    public void GenerateRequest() throws JSONException {

    }

    @Override
    public boolean GetResponse() throws JSONException {
        return false;
    }

    @Override
    public void ParseResponse() {

    }
}
