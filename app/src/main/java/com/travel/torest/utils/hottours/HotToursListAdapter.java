package com.travel.torest.utils.hottours;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.travel.torest.model.Tour;
import com.travel.torest.model.arrays.ToursArray;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

/**
 * Created by Antony on 09.05.2016.
 */
@EBean
public class HotToursListAdapter extends BaseAdapter{

    @Bean
    ToursArray tours;

    @RootContext
    Context context;

    @Override
    public int getCount() {
        return tours.size();
    }

    @Override
    public Object getItem(int position) {
        return tours.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HotTourItemView hotTourItemView;
        if (convertView == null) {
            hotTourItemView = HotTourItemView_.build(context);
        } else {
            hotTourItemView = (HotTourItemView) convertView;
        }

        hotTourItemView.bind((Tour)getItem(position));

        return hotTourItemView;
    }
}

