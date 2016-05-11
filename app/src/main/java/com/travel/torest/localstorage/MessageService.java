package com.travel.torest.localstorage;

import org.androidannotations.annotations.EBean;

@EBean(scope = EBean.Scope.Singleton)
public class MessageService {
    String error = "Ошибка";
    String info;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
