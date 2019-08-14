/*
    Tanggal pengerjaan : 10/08/2019
    Nim : 10116132
    Nama : Rafli Rachmawandi
    Kelas : IF-3 (AKB-3)
 */

package com.example.tugas_uas_akb_if3_10116132.Presenter;

import android.support.design.widget.TextInputLayout;

import com.example.tugas_uas_akb_if3_10116132.Model.RegisterModel;
import com.example.tugas_uas_akb_if3_10116132.View.RegisterView;

public class RegisterPresenterImpt implements RegisterPresenter {

    RegisterView view;
    RegisterModel model;

    public RegisterPresenterImpt(RegisterView view) {
        this.view = view;
        this.model = new RegisterModel(this);
    }


    @Override
    public boolean validateEmail(TextInputLayout input, String email) {
        return model.validateEmail(input, email);
    }

    @Override
    public boolean validateUsername(TextInputLayout input, String username) {
        return model.validateUsername(input, username);
    }

    @Override
    public boolean validatePassword(TextInputLayout input, String password) {
        return model.validatePassword(input, password);
    }
}
