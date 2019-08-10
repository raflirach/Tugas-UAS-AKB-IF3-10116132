package com.example.tugas_uas_akb_if3_10116132;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tugas_uas_akb_if3_10116132.Presenter.LoginPresenter;
import com.example.tugas_uas_akb_if3_10116132.Presenter.LoginPresenterClass;
import com.example.tugas_uas_akb_if3_10116132.View.LoginView;

public class Login extends AppCompatActivity implements LoginView {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    EditText edtName, edtPassword;
    Button btnRegister, btnLogin;

    LoginPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenterClass(this);

        edtName = (EditText) findViewById(R.id.edtName);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegister = (Button) findViewById(R.id.btnRegister);

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        final String username = sharedPreferences.getString("nameKey", null);
        final String password = sharedPreferences.getString("passwordKey", null);

        edtName.setText(username);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(Login.this, Register.class);
                startActivity(registerIntent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strName = edtName.getText().toString();
                String strPassword = edtPassword.getText().toString();
                presenter.onHandleLogin(strName,strPassword,username,password);
            }
        });
    }

    @Override
    public void onSuccess() {
        Toast.makeText(Login.this, "Login Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }
}
