package com.travel.torest.fragments;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.travel.torest.R;
import org.androidannotations.annotations.EFragment;

@EFragment(R.layout.fragment_tourists)
public class TouristsFragment extends Fragment {

    private static final String TAG = "STDude";

    public TouristsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return null;
    }

}
