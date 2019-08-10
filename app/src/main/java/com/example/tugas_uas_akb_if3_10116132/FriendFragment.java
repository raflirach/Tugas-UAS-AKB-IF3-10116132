/*
    Tanggal pengerjaan : 10/08/2019
    Nim : 10116132
    Nama : Rafli Rachmawandi
    Kelas : IF-3 (AKB-3)
 */

package com.example.tugas_uas_akb_if3_10116132;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FriendFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_friend, container, false);
    }
}
