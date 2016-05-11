package com.travel.torest.model;

/**
 * class City(models.Model):
 * city_id = models.AutoField(primary_key=True)
 * city = models.CharField(max_length=45)
 * region = models.ForeignKey('Region', models.DO_NOTHING, blank=True, null=True)
 */
public class City{
    private int id;
    private String city;
    private Country country;

    public City(int id, String city, Country country){
        this.id = id;
        this.city = city;
        this.country = country;
    }

    public City(){
        this.id = 0;
        this.city = "city";
        this.country = new Country();
    }

    @Override
    public boolean equals(Object object){
        City city = (City) object;
        if(city.id == this.id)
            return true;
        else return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
