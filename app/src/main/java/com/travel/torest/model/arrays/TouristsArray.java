package com.travel.torest.model.arrays;

import com.travel.torest.model.Tourist;

import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

/**
 * Created by Antony on 06.05.2016.
 */
@EBean(scope = EBean.Scope.Singleton)
public class TouristsArray extends ArrayList<Tourist> {
    public TouristsArray(){
        this.add(new Tourist());
        this.add(new Tourist());
        this.add(new Tourist());this.add(new Tourist());this.add(new Tourist());this.add(new Tourist());


    }
}
