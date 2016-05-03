package com.travel.torest.network.utils.countries;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.travel.torest.model.CountriesArray;
import com.travel.torest.model.Country;
import com.travel.torest.network.utils.ModelFinder;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.List;

/**
 * Created by Antony on 03.05.2016.
 */

@EBean
public class CountriesListAdapter extends BaseAdapter{
    @Bean
    CountriesArray countries;

    @RootContext
    Context context;

   /* @Bean(CountryFinder.class)
    ModelFinder modelFinder;

    @AfterInject
    void initAdapter() {
        countries = (CountriesList)modelFinder.findAll();
    }
*/
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
