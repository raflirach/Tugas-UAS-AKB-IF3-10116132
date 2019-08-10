package com.example.tugas_uas_akb_if3_10116132;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.wang.avi.AVLoadingIndicatorView;

public class SplashActivity extends AppCompatActivity {

    private LinearLayout lv_loading;
    private AVLoadingIndicatorView avi;

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
                Intent i = new Intent(SplashActivity.this, InfoApp.class);
                startActivity(i);
                finish();
            }
        },5000);
    }
}
