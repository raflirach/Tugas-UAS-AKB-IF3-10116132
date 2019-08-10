package com.example.tugas_uas_akb_if3_10116132.Presenter;

public interface RegisterPresenter {
    void onHandleRegister(String username, String password);
    void onSuccess();
    void onError(String message);
}
