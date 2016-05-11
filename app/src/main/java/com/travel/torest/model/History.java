package com.travel.torest.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Antony on 10.05.2016.
 */
public class History {
    //history data
    private int id;
    private Date search_date;

    //search data
    private int city_id;
    private String city;
    private int country_id;
    private String country;
    private ArrayList<Resort> resorts;
    private ArrayList<Hotel> hotels;
    private Date begin_date;
    private Date end_date;
    private int man_count;
    private int kid_count;

    public History(int id, int city_id, String city, int country_id, String country,
                   ArrayList<Resort> resorts, ArrayList<Hotel> hotels, Date begin_date, Date end_date,
                   int man_count, int kid_count, Date search_date){
        this.id = id;
        this.city_id = city_id;
        this.city = city;
        this.country_id = country_id;
        this.country = country;
        this.resorts = resorts;
        this.hotels = hotels;
        this.begin_date = begin_date;
        this.end_date = end_date;
        this.man_count = man_count;
        this.kid_count = kid_count;
        this.search_date = search_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ArrayList<Resort> getResorts() {
        return resorts;
    }

    public void setResorts(ArrayList<Resort> resorts) {
        this.resorts = resorts;
    }

    public ArrayList<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(ArrayList<Hotel> hotels) {
        this.hotels = hotels;
    }

    public Date getBegin_date() {
        return begin_date;
    }

    public void setBegin_date(Date begin_date) {
        this.begin_date = begin_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public int getMan_count() {
        return man_count;
    }

    public void setMan_count(int man_count) {
        this.man_count = man_count;
    }

    public int getKid_count() {
        return kid_count;
    }

    public void setKid_count(int kid_count) {
        this.kid_count = kid_count;
    }

    public Date getSearch_date() {
        return search_date;
    }

    public void setSearch_date(Date search_date) {
        this.search_date = search_date;
    }
}
