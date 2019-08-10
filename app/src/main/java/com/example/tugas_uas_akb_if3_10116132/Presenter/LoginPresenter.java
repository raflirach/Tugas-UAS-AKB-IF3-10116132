/*
    Tanggal pengerjaan : 10/08/2019
    Nim : 10116132
    Nama : Rafli Rachmawandi
    Kelas : IF-3 (AKB-3)
 */

package com.example.tugas_uas_akb_if3_10116132.Presenter;

public interface LoginPresenter {
    void onHandleLogin(String username, String password, String dataUsername, String dataPassword);
    void onSuccess();
    void onError(String message);
}
