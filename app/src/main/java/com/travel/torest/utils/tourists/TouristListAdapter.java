package com.travel.torest.utils.tourists;

/**
 * Created by Antony on 07.05.2016.
 */
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.travel.torest.model.Tourist;
import com.travel.torest.model.arrays.TouristsArray;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

@EBean
public class TouristListAdapter extends BaseAdapter {
    @Bean
    TouristsArray tourists;

    @RootContext
    Context context;

    @Override
    public int getCount() {
        return tourists.size();
    }

    @Override
    public Object getItem(int position) {
        return tourists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TouristItemView touristItemView;
        if (convertView == null) {
            touristItemView = TouristItemView_.build(context);
        } else {
            touristItemView = (TouristItemView) convertView;
        }

        touristItemView.bind((Tourist)getItem(position));

        return touristItemView;
    }
}
