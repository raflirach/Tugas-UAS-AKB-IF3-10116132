package com.example.tugas_uas_akb_if3_10116132.Presenter;

import com.example.tugas_uas_akb_if3_10116132.Model.MainModel;
import com.example.tugas_uas_akb_if3_10116132.View.MainView;

public class MainPresenterImpt implements MainPresenter {
    MainView view;
    MainModel model;

    public MainPresenterImpt(MainView view) {
        this.view = view;
        this.model = new MainModel(this);
    }

    @Override
    public void SESSION() {
        view.SESSION();
    }
}
