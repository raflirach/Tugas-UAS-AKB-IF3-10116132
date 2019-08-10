package com.example.tugas_uas_akb_if3_10116132.Presenter;

public interface LoginPresenter {
    void onHandleLogin(String username, String password, String dataUsername, String dataPassword);
    void onSuccess();
    void onError(String message);
}
