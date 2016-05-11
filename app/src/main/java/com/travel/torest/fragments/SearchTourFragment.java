package com.travel.torest.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.travel.torest.R;
import com.travel.torest.localstorage.CacheService;
import com.travel.torest.model.Country;
import com.travel.torest.model.History;
import com.travel.torest.model.Hotel;
import com.travel.torest.model.Resort;
import com.travel.torest.model.arrays.HotelsArray;
import com.travel.torest.model.arrays.ResortsArray;
import com.travel.torest.screens.CitiesActivity_;
import com.travel.torest.screens.CountriesActivity_;
import com.travel.torest.screens.HotelCategoriesActivity_;
import com.travel.torest.screens.HotelsActivity_;
import com.travel.torest.screens.ResortsActivity_;


import org.androidannotations.annotations.*;

import java.util.ArrayList;
import java.util.Date;

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
    @ViewById(R.id.NumberOfNightsSB) SeekBar numberOfNightsSB;
    @ViewById(R.id.ManCountTV) TextView manCountTV;
    @ViewById(R.id.KidCountTV) TextView kidCountTV;
    @ViewById(R.id.KidButton1) ImageButton kidButton1;
    @ViewById(R.id.KidButton2) ImageButton kidButton2;
    @ViewById(R.id.KidButton3) ImageButton kidButton3;
    @ViewById(R.id.KidButton4) ImageButton kidButton4;
    @ViewById(R.id.ManButton1) ImageButton manButton1;
    @ViewById(R.id.ManButton2) ImageButton manButton2;
    @ViewById(R.id.ManButton3) ImageButton manButton3;
    @ViewById(R.id.ManButton4) ImageButton manButton4;

    @Bean
    CacheService cache;

    @Bean
    ResortsArray resorts;

    @Bean
    HotelsArray hotels;

    @AfterViews
    void init(){
        cacheInit();
        Log.i(TAG, "success cache init");
        beginDestTV.setText(cache.getCache().getCity());
        endDestTV.setText(cache.getCache().getCountry());
        String resorts = "";
        for (int i = 0; i < cache.getCache().getResorts().size(); i++) {
            resorts += cache.getCache().getResorts().get(i).getCity();
            if (i != cache.getCache().getResorts().size() - 1)
                resorts += ", ";
        }
        resortTV.setText(resorts);
        String hotels = "";
        for (int i = 0; i < cache.getCache().getHotels().size(); i++) {
            hotels += cache.getCache().getHotels().get(i).getName();
            if (i != cache.getCache().getHotels().size() - 1)
                hotels += ", ";
        }
        resortTV.setText(hotels);
        hotelCategoryTV.setText("Все категории");
        supplyTV.setText("Все категории");
        Log.i(TAG, "DAY ++ " + cache.getCache().getBegin_date().getDay());
        beginDestDayTV.setText(String.valueOf(cache.getCache().getBegin_date().getDay()));
        beginDestMonthTV.setText(String.valueOf(cache.getCache().getBegin_date().getMonth()));
        beginDestYearTV.setText(String.valueOf(cache.getCache().getBegin_date().getYear()));
        endDestDayTV.setText(String.valueOf(cache.getCache().getEnd_date().getDay()));
        endDestMonthTV.setText(String.valueOf(cache.getCache().getEnd_date().getMonth()));
        endDestYearTV.setText(String.valueOf(cache.getCache().getEnd_date().getYear()));
        manCountTV.setText("("+String.valueOf(cache.getCache().getMan_count())+")");
        kidCountTV.setText("("+String.valueOf(cache.getCache().getKid_count())+")");
    }



    @Click(R.id.EndDestinationLayout)
    void endDestLClick(){
        Intent intent = new Intent(getActivity(), CountriesActivity_.class);
        startActivity(intent);
    }

    @Click(R.id.BeginDestinationLayout)
    void begDestLClick(){
        Intent intent = new Intent(getActivity(), CitiesActivity_.class);
        startActivity(intent);
    }

    @Click(R.id.HotelCategoryLayout)
    void hotelCategoryLClick(){
        Intent intent = new Intent(getActivity(), HotelCategoriesActivity_.class);
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
        startActivity(intent);
    }

    @Click(R.id.ManButton1)
    void ManButton1Click(){
        manButton1.setImageResource(R.mipmap.icon_man_normal);
        manButton2.setImageResource(R.mipmap.icon_man_selected_normal);
        manButton3.setImageResource(R.mipmap.icon_man_selected_normal);
        manButton4.setImageResource(R.mipmap.icon_man_selected_normal);
        manCountTV.setText("(1)");
    }

    @Click(R.id.ManButton2)
    void ManButton2Click(){
        manButton1.setImageResource(R.mipmap.icon_man_normal);
        manButton2.setImageResource(R.mipmap.icon_man_normal);
        manButton3.setImageResource(R.mipmap.icon_man_selected_normal);
        manButton4.setImageResource(R.mipmap.icon_man_selected_normal);
        manCountTV.setText("(2)");
    }

    @Click(R.id.ManButton3)
    void ManButton3Click(){
        manButton1.setImageResource(R.mipmap.icon_man_normal);
        manButton2.setImageResource(R.mipmap.icon_man_normal);
        manButton3.setImageResource(R.mipmap.icon_man_normal);
        manButton4.setImageResource(R.mipmap.icon_man_selected_normal);
        manCountTV.setText("(3)");
    }

    @Click(R.id.ManButton4)
    void ManButton4Click(){
        manButton1.setImageResource(R.mipmap.icon_man_normal);
        manButton2.setImageResource(R.mipmap.icon_man_normal);
        manButton3.setImageResource(R.mipmap.icon_man_normal);
        manButton4.setImageResource(R.mipmap.icon_man_normal);
        manCountTV.setText("(4)");
    }

    @Click(R.id.KidButton1)
    void KidButton1Click(){
        if(kidCountTV.getText().toString().equals("(1)")){
            kidButton1.setImageResource(R.mipmap.icon_kid_selected_normal);
            kidCountTV.setText("(0)");
        }
        else {
            kidButton1.setImageResource(R.mipmap.icon_kid_normal);
            kidButton2.setImageResource(R.mipmap.icon_kid_selected_normal);
            kidButton3.setImageResource(R.mipmap.icon_kid_selected_normal);
            kidButton4.setImageResource(R.mipmap.icon_kid_selected_normal);
            kidCountTV.setText("(1)");
        }
    }

    @Click(R.id.KidButton2)
    void KidButton2Click(){
        kidButton1.setImageResource(R.mipmap.icon_kid_normal);
        kidButton2.setImageResource(R.mipmap.icon_kid_normal);
        kidButton3.setImageResource(R.mipmap.icon_kid_selected_normal);
        kidButton4.setImageResource(R.mipmap.icon_kid_selected_normal);
        kidCountTV.setText("(2)");
    }

    @Click(R.id.KidButton3)
    void KidButton3Click(){
        kidButton1.setImageResource(R.mipmap.icon_kid_normal);
        kidButton2.setImageResource(R.mipmap.icon_kid_normal);
        kidButton3.setImageResource(R.mipmap.icon_kid_normal);
        kidButton4.setImageResource(R.mipmap.icon_kid_selected_normal);
        kidCountTV.setText("3");
    }

    @Click(R.id.KidButton4)
    void KidButton4Click(){
        kidButton1.setImageResource(R.mipmap.icon_kid_normal);
        kidButton2.setImageResource(R.mipmap.icon_kid_normal);
        kidButton3.setImageResource(R.mipmap.icon_kid_normal);
        kidButton4.setImageResource(R.mipmap.icon_kid_normal);
        kidCountTV.setText("(4)");
    }

    private void cacheInit(){
        Country country = new Country(428, "Болгария");
        Resort resort = new Resort(0, "Любой", country);
        Hotel hotel = new Hotel(0, "Любой", null, 0, 0, 0);
        ArrayList<Resort> resortArrayList = new ArrayList<Resort>();
        ArrayList<Hotel> hotelArrayList = new ArrayList<Hotel>();
        resortArrayList.add(resort);
        hotelArrayList.add(hotel);
        cache.setCache(new History(0, 269, "Минск", country.getId(), country.getCountry(),
                resortArrayList, hotelArrayList, new Date(), new Date(), 1, 0, new Date()));
    }

}
