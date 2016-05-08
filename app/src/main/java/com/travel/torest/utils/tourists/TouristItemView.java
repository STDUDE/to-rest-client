package com.travel.torest.utils.tourists;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.travel.torest.R;
import com.travel.torest.model.Tourist;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Antony on 07.05.2016.
 */

@EViewGroup(R.layout.view_tourist_list_item)
public class TouristItemView extends LinearLayout {

    private static final String ManAgeCategory = "взрослый";
    private static final String KidAgeCategory = "ребенок";

    @ViewById(R.id.TouristItemFullName) TextView touristItemFullName;
    @ViewById(R.id.TouristItemBDate) TextView touristItemBDate;
    @ViewById(R.id.TouristItemAgeCategory) TextView touristItemAgeCategory;
    @ViewById(R.id.TouristItemSeria) TextView touristItemSeria;
    @ViewById(R.id.TouristItemNumber) TextView touristItemNumber;
    @ViewById(R.id.TouristItemIssuedBy) TextView touristItemIssuedBy;
    @ViewById(R.id.TouristItemDateOfIssue) TextView touristItemDateOfIssue;
    @ViewById(R.id.TouristItemIcon) ImageView touristItemIcon;

    public TouristItemView(Context context) {
        super(context);
    }

    public void bind(Tourist tourist) {
        this.touristItemFullName.setText(tourist.getFirst_name() + " " + tourist.getLast_name());
        this.touristItemAgeCategory.setText(tourist.getAge_category());
        this.touristItemBDate.setText((CharSequence) tourist.getBdate());
        switch (tourist.getGender()){
            case 1:
                this.touristItemIcon.setImageResource(R.drawable.add_tourist_man);
                break;
            case 2:
                this.touristItemIcon.setImageResource(R.drawable.add_tourist_woman);
                break;
        }
        this.touristItemSeria.setText(tourist.getSearia());
        this.touristItemNumber.setText(tourist.getNumber());
        this.touristItemIssuedBy.setText(tourist.getIssued_by());
        this.touristItemDateOfIssue.setText((CharSequence) tourist.getBegin_date());

    }
}
