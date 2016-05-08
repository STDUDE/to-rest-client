package com.travel.torest.utils.hotelcategories;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.travel.torest.model.arrays.HotelCategoriesArray;
import com.travel.torest.utils.hotelcategories.HotelCategoryItemView;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

/**
 * Created by Antony on 05.05.2016.
 */

@EBean
public class HotelCategoriesListAdapter extends BaseAdapter{

    @Bean
    HotelCategoriesArray categories;

    @RootContext
    Context context;

    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Object getItem(int position) {
        return categories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        HotelCategoryItemView hotelCategoryItemView;

        if (convertView == null) {
            hotelCategoryItemView = HotelCategoryItemView_.build(context);
        } else {
            hotelCategoryItemView = (HotelCategoryItemView) convertView;
        }

        hotelCategoryItemView.bind((Integer)getItem(position));

        return hotelCategoryItemView;
    }
}
