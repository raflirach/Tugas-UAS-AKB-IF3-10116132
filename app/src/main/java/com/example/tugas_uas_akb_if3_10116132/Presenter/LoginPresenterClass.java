package com.example.tugas_uas_akb_if3_10116132.Presenter;

import com.example.tugas_uas_akb_if3_10116132.Model.LoginModel;
import com.example.tugas_uas_akb_if3_10116132.View.LoginView;

public class LoginPresenterClass implements LoginPresenter {
    private LoginView view;
    private LoginModel model;

    public LoginPresenterClass(LoginView view){
        this.view=view;
        this.model=new LoginModel(this);
    }

    @Override
    public void onHandleLogin(String username, String password, String dataUsername, String dataPassword) {
        model.validateUser(username,password,dataUsername,dataPassword);
    }

    @Override
    public void onSuccess() {
        view.onSuccess();
    }

    @Override
    public void onError(String message) {
        view.onError(message);
    }
}
