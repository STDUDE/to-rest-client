package com.travel.torest.utils.hotcountries;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.travel.torest.R;
import com.travel.torest.model.Country;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Antony on 09.05.2016.
 */
@EViewGroup(R.layout.view_hotcountries_list_item)
public class HotCountryItemView extends LinearLayout {

    public HotCountryItemView(Context context) {
        super(context);
    }

    public void bind(Country country) {

    }
}
