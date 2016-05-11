package com.travel.torest.network.sendings;

import android.util.Log;

import com.travel.torest.network.Request;
import com.travel.torest.network.RequestCreator;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

/**
 * Created by Antony on 10.05.2016.
 */
@EBean
public class SendEmailRequestCreator implements RequestCreator {
    private static final String TAG = "STDude";

    @Bean
    SendEmailRequest request;

    @Override
    public Request ConcreteRequestCreator() {
        Log.i(TAG, "Send email request creator");
        return request;
    }
}
