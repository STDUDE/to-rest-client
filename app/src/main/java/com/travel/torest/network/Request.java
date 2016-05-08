package com.travel.torest.network;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Antony on 02.05.2016.
 */
public interface Request {
    public void GenerateRequest() throws JSONException;
    public boolean GetResponse() throws JSONException;
    public void ParseResponse();
}
