/*
    Tanggal pengerjaan : 10/08/2019
    Nim : 10116132
    Nama : Rafli Rachmawandi
    Kelas : IF-3 (AKB-3)
 */

package com.example.tugas_uas_akb_if3_10116132.Presenter;

public interface RegisterPresenter {
    void onHandleRegister(String username, String password);
    void onSuccess();
    void onError(String message);
}
