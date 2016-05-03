package com.travel.torest.network;

import com.travel.torest.network.address.ReqCountriesS;

/**
 * Created by Antony on 02.05.2016.
 */
public class RequestCreator {
    public Request ConcreteRequestCreator(String type) {
        if (type.equals("ReqCountriesS")) {
            return new ReqCountriesS();
        }
        else {
            return  new DefaultReq();
        }
    }
}
