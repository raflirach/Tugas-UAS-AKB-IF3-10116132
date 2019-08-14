/*
    Tanggal pengerjaan : 14/08/2019
    Nim : 10116132
    Nama : Rafli Rachmawandi
    Kelas : IF-3 (AKB-3)
 */


package com.example.tugas_uas_akb_if3_10116132.Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class UserModel extends RealmObject {
    @PrimaryKey
    private int id;

    private String nim;
    private String nama;
    private String kelas;
    private String telepon;
    private String email;
    private String instagram;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }
}
