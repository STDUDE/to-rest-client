package com.travel.torest.model;

/**
 * Created by Antony on 09.05.2016.
 */
public class HotelCategory {
    private int id;
    private String category;

    public HotelCategory(int id, String category){
        this.id = id;
        this.category = category;
    }

    @Override
    public boolean equals(Object object){
        HotelCategory category = (HotelCategory) object;
        if(category.id == this.id)
            return true;
        else return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
