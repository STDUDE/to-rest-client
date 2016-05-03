package com.travel.torest.model;

import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

/**
 * Created by Antony on 03.05.2016.
 */
@EBean(scope = EBean.Scope.Singleton)
public class CountriesArray extends ArrayList<Country> {
}
