/*
    Tanggal pengerjaan : 10/08/2019
    Nim : 10116132
    Nama : Rafli Rachmawandi
    Kelas : IF-3 (AKB-3)
 */

package com.example.tugas_uas_akb_if3_10116132.Presenter;

import com.example.tugas_uas_akb_if3_10116132.Model.RegisterModel;
import com.example.tugas_uas_akb_if3_10116132.View.RegisterView;

public class RegisterPresenterClass implements RegisterPresenter {

    RegisterView view;
    RegisterModel model;

    public RegisterPresenterClass(RegisterView view) {
        this.view = view;
        this.model = new RegisterModel(this);
    }

    @Override
    public void onHandleRegister(String username, String password) {
        model.validate(username,password);
    }

    @Override
    public void onSuccess() {
        view.onSuccess();
    }

    @Override
    public void onError(String message) {
        view.onError(message);
    }
}
