package com.travel.torest.model;

/**
 * class Region(models.Model):
 * region_id = models.AutoField(primary_key=True)
 * region = models.CharField(max_length=45)
 * country = models.ForeignKey(Country, models.DO_NOTHING)
 */

public class Region {
    private int id;
    private String region;
    private Country country;

    public Region(int id, String region, Country country){
        this.id = id;
        this.region = region;
        this.country = country;
    }

    @Override
    public boolean equals(Object object){
        Region region = (Region)object;
        if(region.id == this.id)
            return true;
        else return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
