/*
    Tanggal pengerjaan : 14/08/2019
    Nim : 10116132
    Nama : Rafli Rachmawandi
    Kelas : IF-3 (AKB-3)
 */

package com.example.tugas_uas_akb_if3_10116132.Database;

import android.util.Log;

import com.example.tugas_uas_akb_if3_10116132.Model.User;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class RealmHelper {
    Realm realm;

    public RealmHelper(Realm realm) {
        this.realm = realm;
    }

    //save data to realm
    public void save(final User user){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if (realm != null){
                    Log.e("success","database was created");
                    Number currentIdNum = realm.where(User.class).max("id");
                    int nextId;
                    if(currentIdNum == null){
                        nextId = 1;
                    }else {
                        nextId = currentIdNum.intValue() + 1;
                    }
                    user.setId(nextId);
                    User u = realm.copyToRealm(user);
                }else{
                    Log.e("failed","database not exist");
                }
            }
        });
    }

    //select data from realm
    public List<User> getAllUser(){
        RealmResults<User> users = realm.where(User.class).findAll();
        return users;
    }

    //edit
    public void update(final int id, final String nim, final String nama, final String kelas, final String telepon, final String email, final String instagram){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                User users = realm.where(User.class)
                        .equalTo("id",id)
                        .findFirst();

                users.setNim(nim);
                users.setNama(nama);
                users.setKelas(kelas);
                users.setTelepon(telepon);
                users.setEmail(email);
                users.setInstagram(instagram);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.e("success","Update Successfully");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                error.printStackTrace();
            }
        });
    }

    //delete
    public void delete(final int id){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                User users = realm.where(User.class)
                        .equalTo("id",id)
                        .findFirst();

                users.deleteFromRealm();
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.e("success","Update Successfully");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                error.printStackTrace();
            }
        });
    }
}