/*
    Tanggal pengerjaan : 14/08/2019
    Nim : 10116132
    Nama : Rafli Rachmawandi
    Kelas : IF-3 (AKB-3)
 */

package com.example.tugas_uas_akb_if3_10116132.Presenter;

import com.example.tugas_uas_akb_if3_10116132.Model.SplashModel;
import com.example.tugas_uas_akb_if3_10116132.View.SplashView;

public class SplashPresenterImpt implements SplashPresenter {

    SplashView view;
    SplashModel model;

    public SplashPresenterImpt(SplashView view) {
        this.view = view;
        this.model = new SplashModel(this);
    }

    @Override
    public void firstTime() {
        view.firstTime();
    }
}
