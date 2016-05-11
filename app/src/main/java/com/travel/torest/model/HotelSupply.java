package com.travel.torest.model;

/**
 * Created by Antony on 09.05.2016.
 */
public class HotelSupply {
    private int id;
    private String supply;

    public HotelSupply(int id, String supply){
        this.id = id;
        this.supply = supply;
    }

    @Override
    public boolean equals(Object object){
        HotelSupply supply = (HotelSupply) object;
        return supply.id == this.id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSupply() {
        return supply;
    }

    public void setSupply(String supply) {
        this.supply = supply;
    }
}
