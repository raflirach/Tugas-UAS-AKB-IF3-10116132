/*
    Tanggal pengerjaan : 07/08/2019
    Nim : 10116132
    Nama : Rafli Rachmawandi
    Kelas : IF-3 (AKB-3)
 */

package com.example.tugas_uas_akb_if3_10116132.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.tugas_uas_akb_if3_10116132.R;

public class SlideAdapter extends PagerAdapter{
    Context context;
    LayoutInflater layoutInflater;

    public SlideAdapter(Context context){
        this.context = context;
    }

    public int[] slide_image = {
            R.drawable.ic_person_200dp,
            R.drawable.ic_contact_200dp,
            R.drawable.ic_group_200dp
    };

    public String[] slide_header = {
            "PROFIL",
            "KONTAK",
            "DAFTAR TEMAN"
    };

    public String[] slide_desc = {
            "Menampilkan informasi tentang pengguna berupa Foto diri, nim, nama dan deskripsi diri",
            "Menampilkan informasi tentang kontak pengguna berupa social media pribadi pengguna",
            "Menampilkan informasi list teman dengan list dan ditampilkan pada viewPager dengan " +
                    "CardView. Data teman dapat ditambah, dimodifikasi dan dihapus"
    };

    @Override
    public int getCount() {
        return slide_header.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container,false);

        ImageView slideImage = (ImageView)view.findViewById(R.id.slideImage);
        TextView slideHeader = (TextView)view.findViewById(R.id.slideHeading);
        TextView slideDesc = (TextView)view.findViewById(R.id.slideDesc);

        slideImage.setImageResource(slide_image[position]);
        slideHeader.setText(slide_header[position]);
        slideDesc.setText(slide_desc[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
