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

import com.example.tugas_uas_akb_if3_10116132.Database.RealmHelper;
import com.example.tugas_uas_akb_if3_10116132.Model.SplashModel;
import com.example.tugas_uas_akb_if3_10116132.Model.UserModel;
import com.example.tugas_uas_akb_if3_10116132.View.SplashView;
import com.wang.avi.AVLoadingIndicatorView;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class SplashActivity extends AppCompatActivity implements SplashView {

    Realm realm;
    RealmHelper realmHelper;

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
            dataAwal();

            startActivity(new Intent(SplashActivity.this,InfoApp.class));
            SplashModel.save(getApplicationContext(),"first","true");
            finish();
        }
    }

    private void dataAwal() {
        RealmConfiguration configuration = new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
        realm = Realm.getInstance(configuration);

        UserModel userModel = new UserModel();
        userModel.setNim("10116132");
        userModel.setNama("Rafli Rachmawandi");
        userModel.setEmail("rafli060395@gmail.com");
        userModel.setKelas("IF-3");
        userModel.setTelepon("08112004240");
        userModel.setInstagram("@raflirach");
        realmHelper = new RealmHelper(realm);
        realmHelper.save(userModel);

        UserModel userModel2 = new UserModel();
        userModel2.setNim("10116190");
        userModel2.setNama("Agus");
        userModel2.setEmail("sugaagus@gmail.com");
        userModel2.setKelas("IF-5");
        userModel2.setTelepon("081322841066");
        userModel2.setInstagram("@agusagus");

        realmHelper = new RealmHelper(realm);
        realmHelper.save(userModel2);
    }
}
