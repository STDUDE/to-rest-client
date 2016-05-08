package com.travel.torest.model.arrays;

import com.travel.torest.model.City;

import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

/**
 * Created by Antony on 05.05.2016.
 */
@EBean(scope = EBean.Scope.Singleton)
public class CitiesArray extends ArrayList<City> {
    public CitiesArray(){
        this.add(new City());
        this.add(new City());
        this.add(new City());
    }
}
