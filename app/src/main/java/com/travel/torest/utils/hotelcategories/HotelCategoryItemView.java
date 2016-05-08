package com.travel.torest.utils.hotelcategories;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.RatingBar;

import com.travel.torest.R;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Antony on 05.05.2016.
 */
@EViewGroup(R.layout.view_hotelcategory_list_item)
public class HotelCategoryItemView extends LinearLayout {
    @ViewById(R.id.HotelCategory)
    RatingBar hotelCategory;

    public HotelCategoryItemView(Context context) {
        super(context);
    }

    public void bind(Integer category) {
        this.hotelCategory.setNumStars(category);
        this.hotelCategory.setRating(category);
    }
}
