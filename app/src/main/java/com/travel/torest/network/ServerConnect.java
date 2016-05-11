package com.travel.torest.network;

import android.util.Log;

import com.travel.torest.localstorage.CacheService;
import com.travel.torest.localstorage.MessageService;

import org.androidannotations.annotations.Bean;
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

    @Bean
    MessageService message;

    private static final int TIMEOUT_MILLISEC = 20000;

    private static final String URL_API_V1 = "http://to-rest-server.herokuapp.com/webapp/webservice/";
    private String url;
    private String request;
    private String response;

    public void setDataToServer(String _request){
        request = _request;
    }
    public void setURL(String _url){
        url = _url;
    }

    public boolean testPOST() {
        BufferedReader br = null;
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
            osw.close();

            Log.i(TAG, "CLIENT SEND REQUEST:" + request);

            br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            StringBuilder sb = new StringBuilder();
            String line = null;

            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            Log.i(TAG, "HTTP RESPONSE:" + sb.toString());

            response = sb.toString();
            return test(new JSONObject(response));

        } catch (MalformedURLException e) {
            message.setError("Ошибка сервера");
            e.printStackTrace();
        } catch (ProtocolException e) {
            message.setError("Ошибка сервера");
            e.printStackTrace();
        } catch (JSONException e) {
            message.setError("Ошибка чтения данных");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public boolean testGET(){
        while (true) {
            try {
                Log.i(TAG, "HTTP REQUEST:" + URL_API_V1 + url);
                URL _url = new URL(URL_API_V1 + url);
                HttpURLConnection connection = (HttpURLConnection) _url.openConnection();
                connection.setRequestMethod("GET");
                connection.setReadTimeout(TIMEOUT_MILLISEC);
                connection.connect();

                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
                StringBuilder sb = new StringBuilder();
                String line = null;

                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();
                Log.i(TAG, "HTTP RESPONSE:" + sb.toString());

                response = sb.toString();
                return test(new JSONObject(response));

            } catch (JSONException | IOException e) {
                e.printStackTrace();
            }
            return false;
        }
    }

    public boolean test(JSONObject json) throws JSONException {
        return !json.get("status").equals("error");
    }

    public Object getErrorMessage(JSONObject json) throws JSONException {
        return json.get("message");
    }

    public String getResponse(){
        return response;
    }
}
