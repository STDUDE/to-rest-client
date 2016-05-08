package com.travel.torest.utils.countries;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.travel.torest.model.arrays.CountriesArray;
import com.travel.torest.model.Country;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

/**
 * Created by Antony on 03.05.2016.
 */

@EBean
public class CountriesListAdapter extends BaseAdapter{
    @Bean
    CountriesArray countries;

    @RootContext
    Context context;

    @Override
    public int getCount() {
        return countries.size();
    }

    @Override
    public Object getItem(int position) {
        return countries.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CountryItemView countryItemView;
        if (convertView == null) {
            countryItemView = CountryItemView_.build(context);
        } else {
            countryItemView = (CountryItemView) convertView;
        }

        countryItemView.bind((Country)getItem(position));

        return countryItemView;
    }

}
