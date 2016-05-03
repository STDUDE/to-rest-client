package com.travel.torest.network;

import android.util.Log;

import org.androidannotations.annotations.EBean;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by Antony on 02.05.2016.
 */
@EBean(scope = EBean.Scope.Singleton)
public class ServerConnect {
    private static String TAG = "STDude";

    private static final int TIMEOUT_MILLISEC = 20000;

    private static final String URL_API_V1 = "http://to-rest_server.herokuapp.com/webservice/api/v1/";
    private String request;
    private String response;
    private JSONObject json_resp;

    public void setDataToServer(String request){
        this.request = request;
    }

    public boolean testPOST(String url) {
        while (true) {
            try {
                Log.i(TAG, "HTTP REQUEST:" + URL_API_V1 + url);
                URL _url = new URL(URL_API_V1 + url);
                HttpURLConnection connection = (HttpURLConnection) _url.openConnection();
                connection.setRequestMethod("POST");
                connection.setReadTimeout(TIMEOUT_MILLISEC);
                connection.connect();

                OutputStream os = connection.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
                osw.write(request);

                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
                StringBuilder sb = new StringBuilder();
                String line = null;

                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();
                Log.i(TAG, "HTTP RESPONSE:" + sb.toString());
                if((test(json_resp))) return true;
                else return false;

            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }
    }

    public boolean testGET(String url){
        while (true) {
            try {
                Log.i(TAG, "HTTP REQUEST:" + URL_API_V1 + url);
                URL _url = new URL(URL_API_V1 + url);
                HttpURLConnection connection = (HttpURLConnection) _url.openConnection();
                connection.setRequestMethod("GET");
                connection.setReadTimeout(TIMEOUT_MILLISEC);
                connection.connect();

                OutputStream os = connection.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
                osw.write(request);

                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
                StringBuilder sb = new StringBuilder();
                String line = null;

                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();
                Log.i(TAG, "HTTP RESPONSE:" + sb.toString());
                if((test(json_resp))) return true;
                else return false;

            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }
    }

    public boolean test(JSONObject json) {

        return false;
    }

    public String getResponse(){
        return response;
    }
}
