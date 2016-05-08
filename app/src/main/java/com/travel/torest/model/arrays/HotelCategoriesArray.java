package com.travel.torest.model.arrays;

import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

/**
 * Created by Antony on 05.05.2016.
 */
@EBean(scope = EBean.Scope.Singleton)
public class HotelCategoriesArray extends ArrayList<Integer>{
    public HotelCategoriesArray(){
        for(int category = 1; category <= 5; category++)
            this.add(category);
    }
}
