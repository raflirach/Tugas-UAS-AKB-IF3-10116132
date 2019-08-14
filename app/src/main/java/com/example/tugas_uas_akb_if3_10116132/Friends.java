/*
    Tanggal pengerjaan : 14/08/2019
    Nim : 10116132
    Nama : Rafli Rachmawandi
    Kelas : IF-3 (AKB-3)
 */

package com.example.tugas_uas_akb_if3_10116132;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tugas_uas_akb_if3_10116132.Adapter.UserAdapter;
import com.example.tugas_uas_akb_if3_10116132.Database.RealmHelper;
import com.example.tugas_uas_akb_if3_10116132.Model.User;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class Friends extends AppCompatActivity {

    Realm realm;
    RealmHelper realmHelper;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    UserAdapter adapter;
    List<User> user;

    FloatingActionButton fab;

    EditText edtNim,edtNama,edtKelas,edtEmail,edtTelepon,edtInstagram;
    String strNim, strNama, strKelas, strEmail, strTelepon,strInstagram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        //setup realm
        RealmConfiguration configuration = new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
        realm = Realm.getInstance(configuration);

        recyclerView = (RecyclerView)findViewById(R.id.myRecycler);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        realmHelper = new RealmHelper(realm);
        user = new ArrayList<>();

        user = realmHelper.getAllUser();

        adapter = new UserAdapter( user,this);

        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

        fab = (FloatingActionButton)findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddDialog();
            }
        });
    }

    private void showAddDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Friends.this);
        alertDialog.setTitle("Tambah Kontak");

        LayoutInflater inflater = this.getLayoutInflater();
        View add_layout = inflater.inflate(R.layout.add_layout,null);

        edtNim = (EditText)add_layout.findViewById(R.id.edtNim);
        edtNama = (EditText)add_layout.findViewById(R.id.edtNama);
        edtKelas = (EditText)add_layout.findViewById(R.id.edtKelas);
        edtEmail = (EditText)add_layout.findViewById(R.id.edtEmail);
        edtTelepon = (EditText)add_layout.findViewById(R.id.edtTelepon);
        edtInstagram = (EditText)add_layout.findViewById(R.id.edtInstagram);

        alertDialog.setView(add_layout);
        alertDialog.setIcon(R.drawable.ic_add_black_24dp);

        //set button
        alertDialog.setPositiveButton("Tambah", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

                strNim = edtNim.getText().toString();
                strNama = edtNama.getText().toString();
                strKelas = edtKelas.getText().toString();
                strEmail = edtEmail.getText().toString();
                strTelepon = edtTelepon.getText().toString();
                strInstagram = edtInstagram.getText().toString();

                if(!strNim.isEmpty() && !strNama.isEmpty()){
                    User user = new User();
                    user.setNim(strNim);
                    user.setNama(strNama);
                    user.setEmail(strEmail);
                    user.setKelas(strKelas);
                    user.setTelepon(strTelepon);
                    user.setInstagram(strInstagram);

                    realmHelper = new RealmHelper(realm);
                    realmHelper.save(user);

                    Toast.makeText(Friends.this, "Data Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();

                    edtNim.setText("");
                    edtInstagram.setText("");
                    edtTelepon.setText("");
                    edtEmail.setText("");
                    edtKelas.setText("");
                    edtNama.setText("");
                }else{
                    Toast.makeText(Friends.this, "Data Harus Diisi!", Toast.LENGTH_SHORT).show();
                }

            }
        });
        alertDialog.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Friends.this,BottomNavigation.class));
        finish();
    }
}
