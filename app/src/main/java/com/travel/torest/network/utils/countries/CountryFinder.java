package com.travel.torest.network.utils.countries;

import com.travel.torest.model.CountriesArray;
import com.travel.torest.model.Country;
import com.travel.torest.network.utils.ModelFinder;

import org.androidannotations.annotations.Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Antony on 03.05.2016.
 */

public class CountryFinder implements ModelFinder {
    @Bean
    CountriesArray countries;

    @Override
    public ArrayList findAll() {
        return countries;
    }
}
