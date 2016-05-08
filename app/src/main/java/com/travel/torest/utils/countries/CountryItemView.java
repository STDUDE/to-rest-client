package com.travel.torest.utils.countries;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.travel.torest.R;
import com.travel.torest.model.Country;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Antony on 03.05.2016.
 */
@EViewGroup(R.layout.view_country_list_item)
public class CountryItemView extends LinearLayout{

    @ViewById(R.id.CountryName)
    TextView country;

    public CountryItemView(Context context) {
        super(context);
    }

    public void bind(Country country) {
        this.country.setText(country.getCountry());
    }
}
