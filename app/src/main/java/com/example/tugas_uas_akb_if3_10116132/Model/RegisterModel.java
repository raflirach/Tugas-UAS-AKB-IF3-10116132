/*
    Tanggal pengerjaan : 10/08/2019
    Nim : 10116132
    Nama : Rafli Rachmawandi
    Kelas : IF-3 (AKB-3)
 */

package com.example.tugas_uas_akb_if3_10116132.Model;

import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.util.Patterns;

import com.example.tugas_uas_akb_if3_10116132.Presenter.RegisterPresenter;


public class RegisterModel {

    RegisterPresenter presenter;

    public RegisterModel(RegisterPresenter presenter) {
        this.presenter = presenter;
    }

    public boolean validateEmail(TextInputLayout input, String emailInput){

        if (emailInput.isEmpty()) {
            input.setError("Data tidak boleh kosong");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            input.setError("Email address tidak valid");
            return false;
        } else {
            input.setError(null);
            return true;
        }
    }

    public boolean validateUsername(TextInputLayout inputLayout, String usernameInput) {

        if (usernameInput.isEmpty()) {
            inputLayout.setError("Data tidak boleh kosong");
            return false;
        } else if (usernameInput.length() < 4) {
            inputLayout.setError("Username minimal 4 karakter");
            return false;
        } else {
            inputLayout.setError(null);
            return true;
        }
    }

    public boolean validatePassword(TextInputLayout inputLayout, String passwordInput) {

        if (passwordInput.isEmpty()) {
            inputLayout.setError("Data tidak boleh kosong");
            return false;
        } else if (passwordInput.length() < 4) {
            inputLayout.setError("Password minimal 4 karakter");
            return false;
        } else {
            inputLayout.setError(null);
            return true;
        }
    }
}
