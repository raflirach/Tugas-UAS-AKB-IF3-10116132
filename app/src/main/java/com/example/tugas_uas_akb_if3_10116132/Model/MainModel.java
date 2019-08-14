/*
    Tanggal pengerjaan : 13/08/2019
    Nim : 10116132
    Nama : Rafli Rachmawandi
    Kelas : IF-3 (AKB-3)
 */

package com.example.tugas_uas_akb_if3_10116132.Model;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.tugas_uas_akb_if3_10116132.Presenter.MainPresenter;

public class MainModel {
    MainPresenter presenter;

    public MainModel(MainPresenter presenter) {
        this.presenter = presenter;
    }

    public static void save(Context context, String name, String value){
        SharedPreferences sharedPreferences = context.getSharedPreferences("clipcode",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(name , value);
        editor.apply();
    }

    public static String read(Context context, String name, String defvalue){
        SharedPreferences sharedPreferences = context.getSharedPreferences("clipcode", Context.MODE_PRIVATE);
        return sharedPreferences.getString(name , defvalue);
    }
}
