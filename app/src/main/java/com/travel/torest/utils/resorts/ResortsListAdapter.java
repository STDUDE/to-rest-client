package com.travel.torest.utils.resorts;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.travel.torest.model.Resort;
import com.travel.torest.model.arrays.ResortsArray;
import com.travel.torest.utils.resorts.ResortItemView;
import com.travel.torest.utils.resorts.ResortItemView_;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

/**
 * Created by Antony on 05.05.2016.
 */
@EBean
public class ResortsListAdapter extends BaseAdapter{
    @Bean
    ResortsArray resorts;

    @RootContext
    Context context;

    @Override
    public int getCount() {
        return resorts.size();
    }

    @Override
    public Object getItem(int position) {
        return resorts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ResortItemView resortItemView;
        if (convertView == null) {
            resortItemView = ResortItemView_.build(context);
        } else {
            resortItemView = (ResortItemView) convertView;
        }

        resortItemView.bind((Resort)getItem(position));

        return resortItemView;
    }
}
