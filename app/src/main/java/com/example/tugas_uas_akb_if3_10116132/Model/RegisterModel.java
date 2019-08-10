/*
    Tanggal pengerjaan : 10/08/2019
    Nim : 10116132
    Nama : Rafli Rachmawandi
    Kelas : IF-3 (AKB-3)
 */

package com.example.tugas_uas_akb_if3_10116132.Model;

import android.text.TextUtils;

import com.example.tugas_uas_akb_if3_10116132.Presenter.RegisterPresenter;


public class RegisterModel {

    RegisterPresenter presenter;

    public RegisterModel(RegisterPresenter presenter) {
        this.presenter = presenter;
    }

    public void validate(String username, String password) {

        if(TextUtils.isEmpty(username))
            presenter.onError("Please Enter Username !");
        else if(TextUtils.isEmpty(password))
            presenter.onError("Please Enter Password");
        else if(username.length()<4)
            presenter.onError("Username Must be at least 4 character long !");
        else if(password.length()<4)
            presenter.onError("Password Must be at least 4 character long !");
        else
            presenter.onSuccess();
    }
}
