package com.travel.torest.model.arrays;

import com.travel.torest.model.Country;

import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

/**
 * Created by Antony on 03.05.2016.
 */
@EBean(scope = EBean.Scope.Singleton)
public class CountriesArray extends ArrayList<Country> {
    public CountriesArray(){
        this.add(new Country());
        this.add(new Country());
        this.add(new Country());
        this.add(new Country());
    }
}
