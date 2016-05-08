package com.travel.torest.utils.cities;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.travel.torest.R;
import com.travel.torest.model.City;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Antony on 05.05.2016.
 */
@EViewGroup(R.layout.view_city_list_item)
public class CityItemView extends LinearLayout {
    @ViewById(R.id.CityName)
    TextView city;

    public CityItemView(Context context) {
        super(context);
    }

    public void bind(City city) {
        this.city.setText(city.getCity());
    }
}
