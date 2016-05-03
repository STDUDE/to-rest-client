package com.travel.torest.model;

/**
 * class Country(models.Model):
 * id_country = models.AutoField(primary_key=True)
 * country = models.CharField(max_length=50, blank=True, null=True)
 */

public class Country {
    private int id;
    private String country;

    public Country(int id, String country){
        this.id = id;
        this.country = country;
    }

    @Override
    public boolean equals(Object object){
        Country country = (Country)object;
        if(country.id == this.id)
            return true;
        else return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
