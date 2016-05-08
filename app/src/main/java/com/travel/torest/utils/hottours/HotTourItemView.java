package com.travel.torest.utils.hottours;

import android.content.Context;
import android.widget.LinearLayout;

import com.travel.torest.R;
import com.travel.torest.model.Tour;

import org.androidannotations.annotations.EViewGroup;

/**
 * Created by Antony on 09.05.2016.
 */
@EViewGroup(R.layout.view_hottour_list_item)
public class HotTourItemView extends LinearLayout{
    public HotTourItemView(Context context) {
        super(context);
    }

    public void bind(Tour tour) {
    }
}
