package com.travel.torest.screens;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.travel.torest.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_new_tourist)
public class NewTouristActivity extends AppCompatActivity {

    @ViewById(R.id.toolbar) Toolbar toolbar;

    @ViewById(R.id.AgeCategoryGroup) RadioGroup ageCategoryGroup;
    @ViewById(R.id.ManCategory) RadioButton manCategory;
    @ViewById(R.id.KidCategory) RadioButton kidCategory;
    @ViewById(R.id.TouristFirstName) EditText touristFirstName;
    @ViewById(R.id.TouristLastName) EditText touristLastName;
    @ViewById(R.id.TouristBDate) EditText touristBDate;
    @ViewById(R.id.GenderGroup) RadioGroup genderGroup;
    @ViewById(R.id.ManGender) RadioButton manGender;
    @ViewById(R.id.WomanGender) RadioButton womanGender;
    @ViewById(R.id.Nationality) EditText nationality;
    @ViewById(R.id.TouristPassportSeria) EditText passportSeria;
    @ViewById(R.id.TouristPassportNumber) EditText passportNumber;
    @ViewById(R.id.IssuedBy) EditText passportIssuedBy;
    @ViewById(R.id.BeginDate) EditText passportBegDate;
    @ViewById(R.id.EndDate) EditText passportEndDate;
    @ViewById(R.id.Add) Button add;

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @AfterViews
    protected void init(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.to_rest);
        getSupportActionBar().setTitle(R.string.title_activity_hotels);
    }

    @Click(R.id.Add)
    void AddClick(){

    }

    @Click({R.id.ManCategory, R.id.KidCategory})
    void onAgeCategoryClick(View view){
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.ManCategory:
                if (checked) {
                    // @drawable/add_tourist_radio_button_inactive
                    Toast toast = Toast.makeText(this, "ManCategory", Toast.LENGTH_LONG);
                    toast.show();
                }
                break;
            case R.id.KidCategory:
                if (checked) {
                    // Ninjas rule
                    Toast toast = Toast.makeText(this, "KidCategory", Toast.LENGTH_LONG);
                    toast.show();
                }
                break;
        }
    }

    @Click({R.id.ManGender, R.id.WomanGender})
    void onGenderClick(View view){
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.ManGender:
                if (checked) {
                    // @drawable/add_tourist_radio_button_inactive
                    Toast toast = Toast.makeText(this, "ManGender", Toast.LENGTH_LONG);
                    toast.show();
                }
                break;
            case R.id.WomanGender:
                if (checked) {
                    // Ninjas rule
                    Toast toast = Toast.makeText(this, "WomanGender", Toast.LENGTH_LONG);
                    toast.show();
                }
                break;
        }
    }

    void initTourist(){

    }

}
