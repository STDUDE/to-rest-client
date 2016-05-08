package com.travel.torest.model;

import java.util.Date;

/**
 * Created by Antony on 06.05.2016.
 */
public class Tourist {
    private int id;
    private String first_name;
    private String last_name;
    private String age_category;
    private Date bdate;
    private int gender;
    private String nationality;
    private String searia;
    private String number;
    private String issued_by;
    private Date begin_date;
    private Date end_date;

    public void Tourist(){
        this.id = 0;
        this.first_name = "";
        this.last_name = "";
        this.age_category = "взрослый";
        this.bdate = new Date();
        this.gender = 1;
        this.nationality = "";
        this.searia = "";
        this.number = "";
        this.issued_by = "";
        this.begin_date = new Date();
        this.end_date = new Date();

    }


    @Override
    public boolean equals(Object object){
        Tourist tourist = (Tourist)object;
        if(tourist.id == this.id)
            return true;
        else return false;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAge_category() {
        return age_category;
    }

    public void setAge_category(String age_category) {
        this.age_category = age_category;
    }

    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getSearia() {
        return searia;
    }

    public void setSearia(String searia) {
        this.searia = searia;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getIssued_by() {
        return issued_by;
    }

    public void setIssued_by(String issued_by) {
        this.issued_by = issued_by;
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
}
