/*
    Tanggal pengerjaan : 10/08/2019
    Nim : 10116132
    Nama : Rafli Rachmawandi
    Kelas : IF-3 (AKB-3)
 */

package com.example.tugas_uas_akb_if3_10116132;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tugas_uas_akb_if3_10116132.Model.MainModel;
import com.example.tugas_uas_akb_if3_10116132.Presenter.LoginPresenter;
import com.example.tugas_uas_akb_if3_10116132.Presenter.LoginPresenterImpt;
import com.example.tugas_uas_akb_if3_10116132.View.LoginView;

public class Login extends AppCompatActivity implements LoginView {

    TextInputLayout textUsername,textPassword;
    TextView daftar;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textUsername = (TextInputLayout)findViewById(R.id.textUsername);
        textPassword = (TextInputLayout)findViewById(R.id.textPassword);
        daftar = (TextView)findViewById(R.id.daftarDisini);

        presenter = new LoginPresenterImpt(this);

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,Register.class));
                finish();
            }
        });

    }

    public boolean validateUsername() {
        String usernameInput = textUsername.getEditText().getText().toString().trim();
        final String email = sharedPreferences.getString("emailKey","admin");
        final String username = sharedPreferences.getString("nameKey", "admin");

        return presenter.validateUsername(textUsername,usernameInput,username,email);
    }

    public boolean validatePassword() {
        String passwordInput = textPassword.getEditText().getText().toString().trim();
        final String password = sharedPreferences.getString("passwordKey", "admin");

        return presenter.validatePassword(textPassword, passwordInput, password);
    }

    public void confirmInput(View v) {
        if (!validateUsername() | !validatePassword()) {

        }else {

            Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show();
            MainModel.save(getApplicationContext(),"session","true");
            startActivity(new Intent(Login.this,BottomNavigation.class));
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        System.exit(0);
    }
}
