/*
    Tanggal pengerjaan : 10/08/2019
    Nim : 10116132
    Nama : Rafli Rachmawandi
    Kelas : IF-3 (AKB-3)
 */

package com.example.tugas_uas_akb_if3_10116132.Presenter;

import android.support.design.widget.TextInputLayout;

public interface LoginPresenter {
    boolean validateUsername(TextInputLayout input, String username, String dataUsername, String dataEmail);
    boolean validatePassword(TextInputLayout input, String password, String dataPassword);
}
