package com.travel.torest.model.arrays;

import com.travel.torest.model.Region;

import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

/**
 * Created by Antony on 05.05.2016.
 */
@EBean(scope = EBean.Scope.Singleton)
public class RegionsArray extends ArrayList<Region> {
}
