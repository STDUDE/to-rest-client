package com.travel.torest.utils.resorts;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.travel.torest.R;
import com.travel.torest.model.Resort;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Antony on 05.05.2016.
 */
@EViewGroup(R.layout.view_resort_list_item)
public class ResortItemView extends LinearLayout{
    @ViewById(R.id.ResortName)
    TextView city;

    public ResortItemView(Context context) {
        super(context);
    }

    public void bind(Resort resort) {
        this.city.setText(resort.getCity());
    }


}
