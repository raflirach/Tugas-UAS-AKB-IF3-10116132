/*
    Tanggal pengerjaan : 09/08/2019
    Nim : 10116132
    Nama : Rafli Rachmawandi
    Kelas : IF-3 (AKB-3)
 */
package com.example.tugas_uas_akb_if3_10116132;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.tugas_uas_akb_if3_10116132.Model.MainModel;
import com.example.tugas_uas_akb_if3_10116132.Model.SplashModel;
import com.example.tugas_uas_akb_if3_10116132.View.SplashView;
import com.wang.avi.AVLoadingIndicatorView;

public class SplashActivity extends AppCompatActivity implements SplashView {

    private LinearLayout lv_loading;
    private AVLoadingIndicatorView avi;

    boolean firstTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        lv_loading = (LinearLayout) findViewById(R.id.lv_loading);
        avi = (AVLoadingIndicatorView) findViewById(R.id.avi);
        avi.setIndicator("BallClipRotateMultipleIndicator");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                firstTime();
            }
        },5000);
    }

    @Override
    public void firstTime() {
        firstTime = Boolean.valueOf(SplashModel.read(getApplicationContext(),"first","false"));
        if(firstTime){
            startActivity(new Intent(SplashActivity.this,BottomNavigation.class));
            finish();
        }else{
            startActivity(new Intent(SplashActivity.this,InfoApp.class));
            SplashModel.save(getApplicationContext(),"first","true");
            finish();
        }
    }
}
