package com.travel.torest.model;

/**
 * class DbHostel(models.Model):
 * hostel_id = models.AutoField(primary_key=True)
 * hostel_name = models.CharField(max_length=45, blank=True, null=True)
 * hostel_address = models.ForeignKey(Address, models.DO_NOTHING, db_column='hostel_address', blank=True, null=True)
 * hostel_capacity = models.CharField(max_length=45, blank=True, null=True)
 * hostel_status = models.IntegerField(blank=True, null=True)
 * hostel_supply = models.IntegerField(blank=True, null=True)
 */

public class Hotel {
    private int id;
    private String name;
    private String address;
    private int capacity;
    private int status;
    private int supply;

    public Hotel(int id, String name, String address, int capacity, int status, int supply){
        this.id = id;
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.status = status;
        this.supply = supply;
    }

    @Override
    public boolean equals(Object object){
        Hotel hotel = (Hotel) object;
        return hotel.id == this.id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSupply() {
        return supply;
    }

    public void setSupply(int supply) {
        this.supply = supply;
    }
}

