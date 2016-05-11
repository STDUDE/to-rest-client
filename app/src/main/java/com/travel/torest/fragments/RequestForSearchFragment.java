package com.travel.torest.fragments;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.travel.torest.R;
import com.travel.torest.localstorage.CacheService;
import com.travel.torest.localstorage.MessageService;
import com.travel.torest.network.Request;
import com.travel.torest.network.RequestCreator;
import com.travel.torest.network.sendings.SendEmailRequestCreator;
import com.travel.torest.screens.CitiesActivity_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.json.JSONException;

/**
 * A simple {@link Fragment} subclass.
 */
@EFragment(R.layout.fragment_request_for_search)
public class RequestForSearchFragment extends Fragment {

    private static final String TAG = "STDude";
    ProgressDialog progressDialog;

    @ViewById(R.id.description) EditText description;
    @ViewById(R.id.phone) EditText phone;
    @ViewById(R.id.email) EditText email;

    @Bean
    CacheService cache;

    @Bean
    MessageService messageService;

    @Bean
    SendEmailRequestCreator emailRequestCreator;

    @AfterViews
    void init(){

    }

    @Click(R.id.sendButton)
    void sendBtnClick(){
        progressDialog = ProgressDialog.show(getContext(), getString(R.string.standby_mode),
                "Запрос на отправление заявки", true);
        if(description.getText().toString().isEmpty() ||
                email.getText().toString().isEmpty() ||
                phone.getText().toString().isEmpty()){
            Toast toast = Toast.makeText(getContext(), "Не заполнены данные для поиска", Toast.LENGTH_LONG);
            progressDialog.hide();
            toast.show();
        }
        else send();

    }

    @Click(R.id.callButton)
    void callBtnClick(){

    }

    @Background
    void send() {
        RequestCreator requestCreator = emailRequestCreator;
        Request request = requestCreator.ConcreteRequestCreator();
        try {
            Log.i(TAG, "CLIENT GENERATE REQUEST SEND EMAIL");
            cache.setRequestData(description.getText().toString(), phone.getText().toString(), email.getText().toString());
            request.GenerateRequest();
            if(request.GetResponse()) {
                request.ParseResponse();
                success();
            }
            else {
                failed();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @UiThread
    void success() {
        Toast toast = Toast.makeText(getContext(), messageService.getInfo(), Toast.LENGTH_LONG);
        progressDialog.hide();
        toast.show();
    }

    @UiThread
    void failed() {
        Toast toast = Toast.makeText(getContext(), messageService.getError(), Toast.LENGTH_LONG);
        progressDialog.hide();
        toast.show();
    }
}
