package com.travel.torest.utils.cities;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.travel.torest.model.arrays.CitiesArray;
import com.travel.torest.model.City;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

/**
 * Created by Antony on 05.05.2016.
 */
@EBean
public class CitiesListAdapter extends BaseAdapter {
    @Bean
    CitiesArray cities;

    @RootContext
    Context context;

    @Override
    public int getCount() {
        return cities.size();
    }

    @Override
    public Object getItem(int position) {
        return cities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CityItemView cityItemView;
        if (convertView == null) {
            cityItemView = CityItemView_.build(context);
        } else {
            cityItemView = (CityItemView) convertView;
        }

        cityItemView.bind((City)getItem(position));

        return cityItemView;
    }
}
