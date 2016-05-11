package com.travel.torest.localstorage;

import android.util.Log;

import com.travel.torest.model.City;
import com.travel.torest.model.Country;
import com.travel.torest.model.History;
import com.travel.torest.model.Hotel;
import com.travel.torest.model.HotelCategory;
import com.travel.torest.model.HotelSupply;
import com.travel.torest.model.Resort;
import com.travel.torest.model.arrays.HotelsArray;
import com.travel.torest.model.arrays.ResortsArray;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Antony on 10.05.2016.
 */
@EBean(scope = EBean.Scope.Singleton)
public class CacheService {
    private static final String TAG = "STDude";

    History cache;

    private String description;
    private String phone;
    private String email;

    boolean kid = false;

    public History getCache() {
        return cache;
    }

    public void setCache(History cache) {
        this.cache = cache;
    }

    public void setRequestData(String description, String phone, String email){
        this.description = description;
        this.phone = phone;
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public boolean isKid() {
        return kid;
    }

    public void setKid(boolean kid) {
        this.kid = kid;
    }
}
