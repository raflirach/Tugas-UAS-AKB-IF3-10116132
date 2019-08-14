/*
    Tanggal pengerjaan : 10/08/2019
    Nim : 10116132
    Nama : Rafli Rachmawandi
    Kelas : IF-3 (AKB-3)
 */

package com.example.tugas_uas_akb_if3_10116132.Presenter;

import android.support.design.widget.TextInputLayout;

import com.example.tugas_uas_akb_if3_10116132.Model.LoginModel;
import com.example.tugas_uas_akb_if3_10116132.View.LoginView;

public class LoginPresenterImpt implements LoginPresenter {
    LoginView view;
    LoginModel model;

    public LoginPresenterImpt(LoginView view) {
        this.view = view;
        this.model = new LoginModel(this);
    }

    @Override
    public boolean validateUsername(TextInputLayout input, String username, String dataUsername, String dataEmail) {
        return model.validateUsername(input,username,dataUsername,dataEmail);
    }

    @Override
    public boolean validatePassword(TextInputLayout input, String password, String dataPassword) {
        return model.validatePassword(input,password,dataPassword);
    }
}
