/*
    Tanggal pengerjaan : 10/08/2019
    Nim : 10116132
    Nama : Rafli Rachmawandi
    Kelas : IF-3 (AKB-3)
 */

package com.example.tugas_uas_akb_if3_10116132;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tugas_uas_akb_if3_10116132.Model.MainModel;
import com.example.tugas_uas_akb_if3_10116132.View.MainView;

public class BottomNavigation extends AppCompatActivity implements MainView {

    Boolean session;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_profile:
                    selectedFragment = new ProfileFragment();

                    break;
                case R.id.navigation_contact:
                    selectedFragment = new ContactFragment();
                    //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    break;
                case R.id.navigation_friends:
                    selectedFragment = new FriendFragment();
                    //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    break;
                case R.id.navigation_logout:
                    MainModel.save(getApplicationContext(),"session","false");
                    startActivity(new Intent(BottomNavigation.this,Login.class));
                    finish();
                    break;
            }
            if(selectedFragment!=null){
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                return true;
            }else
                return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        SESSION();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProfileFragment()).commit();
    }

    @Override
    public void SESSION() {
        session = Boolean.valueOf(MainModel.read(getApplicationContext(),"session","false"));
        if(session){
            Toast.makeText(this, "You is Logged in", Toast.LENGTH_SHORT).show();
        }else{
            startActivity(new Intent(BottomNavigation.this,Login.class));
        }
    }
}
