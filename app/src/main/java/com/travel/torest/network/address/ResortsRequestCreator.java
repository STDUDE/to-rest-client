package com.travel.torest.network.address;

import android.util.Log;

import com.travel.torest.network.Request;
import com.travel.torest.network.RequestCreator;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

/**
 * Created by Antony on 05.05.2016.
 */
@EBean
public class ResortsRequestCreator implements RequestCreator {
    public static String TAG = "STDude";

    @Bean
    ResortsRequest resortsRequest;

    @Override
    public Request ConcreteRequestCreator() {
        Log.i(TAG, "Resorts request creator");
        return resortsRequest;
    }
}
