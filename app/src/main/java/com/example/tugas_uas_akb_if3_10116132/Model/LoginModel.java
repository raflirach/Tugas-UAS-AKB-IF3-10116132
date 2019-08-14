/*
    Tanggal pengerjaan : 10/08/2019
    Nim : 10116132
    Nama : Rafli Rachmawandi
    Kelas : IF-3 (AKB-3)
 */

package com.example.tugas_uas_akb_if3_10116132.Model;

import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;

import com.example.tugas_uas_akb_if3_10116132.Presenter.LoginPresenter;


public class LoginModel {

    LoginPresenter presenter;

    public LoginModel(LoginPresenter presenter) {
        this.presenter = presenter;
    }

    public boolean validateUsername(TextInputLayout inputLayout, String usernameInput, String username, String email) {

        if (usernameInput.isEmpty()) {
            inputLayout.setError("Data tidak boleh kosong");
            return false;
        } else if ((!username.equalsIgnoreCase(usernameInput)) && (!email.equalsIgnoreCase(usernameInput))) {
            inputLayout.setError("Username tidak terdaftar");
            return false;
        } else {
            inputLayout.setError(null);
            return true;
        }
    }

    public boolean validatePassword(TextInputLayout inputLayout, String passwordInput, String password) {

        if (passwordInput.isEmpty()) {
            inputLayout.setError("Data tidak boleh kosong");
            return false;
        } else if (!password.equalsIgnoreCase(passwordInput)) {
            inputLayout.setError("Password tidak sesuai");
            return false;
        } else {
            inputLayout.setError(null);
            return true;
        }
    }

}
