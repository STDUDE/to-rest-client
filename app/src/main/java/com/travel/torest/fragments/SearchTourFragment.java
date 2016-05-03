package com.travel.torest.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.travel.torest.R;
import com.travel.torest.screens.CountriesActivity_;
import com.travel.torest.screens.HotelsActivity;
import com.travel.torest.screens.HotelsActivity_;
import com.travel.torest.screens.ResortsActivity;
import com.travel.torest.screens.ResortsActivity_;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * A simple {@link Fragment} subclass.
 */
@EFragment(R.layout.fragment_search_tour)
public class SearchTourFragment extends Fragment {

    private static final String TAG = "STDude";
    @ViewById(R.id.BeginDestinationTV) TextView beginDestTV;
    @ViewById(R.id.EndDestinationTV) TextView endDestTV;
    @ViewById(R.id.ResortTV) TextView resortTV;
    @ViewById(R.id.HotelTV) TextView hotelTV;
    @ViewById(R.id.HotelCategoryTV) TextView hotelCategoryTV;
    @ViewById(R.id.SupplyTV) TextView supplyTV;
    @ViewById(R.id.BeginDestDay) TextView beginDestDayTV;
    @ViewById(R.id.BeginDestMonth) TextView beginDestMonthTV;
    @ViewById(R.id.BeginDestYear) TextView beginDestYearTV;
    @ViewById(R.id.EndDestDay) TextView endDestDayTV;
    @ViewById(R.id.EndDestMonth) TextView endDestMonthTV;
    @ViewById(R.id.EndDestYear) TextView endDestYearTV;
    @ViewById(R.id.NumberOfNightsSB)
    SeekBar numberOfNightsSB;
    @ViewById(R.id.ManCountTV) TextView manCountTV;
    @ViewById(R.id.KidCountTV) TextView kidCountTV;

    public SearchTourFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return null;
    }

    @Click(R.id.EndDestinationLayout)
    void endDestLClick(){
        Intent intent = new Intent(getActivity(), CountriesActivity_.class);
        //intent.putExtra("COUNTRIES_LIST", false);
        startActivity(intent);
    }

    @Click(R.id.HotelLayout)
    void hotelLClick(){
        Intent intent = new Intent(getActivity(), HotelsActivity_.class);
        startActivity(intent);
    }

    @Click(R.id.ResortLayout)
    void resortLClick(){
        Intent intent = new Intent(getActivity(), ResortsActivity_.class);
        //intent.putExtra("region_id", id);
        startActivity(intent);
    }
}
