package com.example.tugas_uas_akb_if3_10116132.Model;

import android.text.TextUtils;

import com.example.tugas_uas_akb_if3_10116132.Presenter.LoginPresenter;


public class LoginModel {

    private LoginPresenter presenter;

    public LoginModel(LoginPresenter presenter){
        this.presenter=presenter;
    }

    public void validateUser(String username, String password , String dataUsername, String dataPassword) {

        if(TextUtils.isEmpty(username))
            presenter.onError("Please Enter Username !");
        else if(TextUtils.isEmpty(password))
            presenter.onError("Please Enter Password");
        else if(!dataUsername.equals(username))
            presenter.onError("Wrong Username !");
        else if(!dataPassword.equals(password))
            presenter.onError("Wrong Password !");
        else
            presenter.onSuccess();
    }

}
