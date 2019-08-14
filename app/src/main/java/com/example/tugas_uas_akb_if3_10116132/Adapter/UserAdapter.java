/*
    Tanggal pengerjaan : 14/08/2019
    Nim : 10116132
    Nama : Rafli Rachmawandi
    Kelas : IF-3 (AKB-3)
 */

package com.example.tugas_uas_akb_if3_10116132.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tugas_uas_akb_if3_10116132.Database.RealmHelper;
import com.example.tugas_uas_akb_if3_10116132.Friends;
import com.example.tugas_uas_akb_if3_10116132.Model.User;
import com.example.tugas_uas_akb_if3_10116132.R;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    private List<User> user;
    Context context;

    Realm realm;
    RealmHelper realmHelper;

    UserAdapter adapter;

    EditText edtNim, edtNama, edtKelas, edtEmail, edtTelepon, edtInstagram;
    int id;
    String nim, nama, kelas, telepon, email, instagram;

    public UserAdapter(List<User> user, Context context) {
        this.user = user;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        User users = user.get(i);
        holder.txtNim.setText(users.getNim());
        holder.txtNama.setText(users.getNama());
        holder.txtKelas.setText(users.getKelas());
        holder.txtTelepon.setText(users.getTelepon());
        holder.txtEmail.setText(users.getEmail());
        holder.txtInstagram.setText(users.getInstagram());
    }

    @Override
    public int getItemCount() {
        return user.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtNim, txtNama, txtKelas, txtEmail, txtTelepon, txtInstagram;
        Button buttonEdit, buttonDelete;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtNim = (TextView) itemView.findViewById(R.id.textNim);
            txtNama = (TextView) itemView.findViewById(R.id.textNama);
            txtKelas = (TextView) itemView.findViewById(R.id.textKelas);
            txtTelepon = (TextView) itemView.findViewById(R.id.textTelepon);
            txtEmail = (TextView) itemView.findViewById(R.id.textEmail);
            txtInstagram = (TextView) itemView.findViewById(R.id.textInstagram);
            buttonEdit = (Button) itemView.findViewById(R.id.button_edit);
            buttonDelete = (Button) itemView.findViewById(R.id.button_delete);

            buttonEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showEditDialog();
                }
            });
            buttonDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDeleteDialog();
                }
            });

        }

        private void showDeleteDialog() {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
            alertDialog.setTitle("Hapus Kontak");
            alertDialog.setMessage("Yakin Ingin Menghapus ?");

            alertDialog.setPositiveButton("Hapus", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();

                    RealmConfiguration configuration = new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
                    realm = Realm.getInstance(configuration);

                    realmHelper = new RealmHelper(realm);
                    realmHelper.delete(user.get(getAdapterPosition()).getId());

                    Toast.makeText(context, "Data Berhasil dihapus", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(context, Friends.class);
                    context.startActivity(intent);
                    ((Activity) context).finish();
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

        private void showEditDialog() {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
            alertDialog.setTitle("Edit Kontak");

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View edit_layout = inflater.inflate(R.layout.edit_layout, null);

            edtNim = (EditText) edit_layout.findViewById(R.id.edtNim);
            edtNama = (EditText) edit_layout.findViewById(R.id.edtNama);
            edtKelas = (EditText) edit_layout.findViewById(R.id.edtKelas);
            edtEmail = (EditText) edit_layout.findViewById(R.id.edtEmail);
            edtTelepon = (EditText) edit_layout.findViewById(R.id.edtTelepon);
            edtInstagram = (EditText) edit_layout.findViewById(R.id.edtInstagram);

            id = user.get(getAdapterPosition()).getId();
            nim = user.get(getAdapterPosition()).getNim();
            nama = user.get(getAdapterPosition()).getNama();
            kelas = user.get(getAdapterPosition()).getKelas();
            telepon = user.get(getAdapterPosition()).getTelepon();
            email = user.get(getAdapterPosition()).getEmail();
            instagram = user.get(getAdapterPosition()).getInstagram();

            edtNim.setText(nim);
            edtNama.setText(nama);
            edtKelas.setText(kelas);
            edtEmail.setText(email);
            edtTelepon.setText(telepon);
            edtInstagram.setText(instagram);

            RealmConfiguration configuration = new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
            realm = Realm.getInstance(configuration);


            alertDialog.setView(edit_layout);
            alertDialog.setIcon(R.drawable.ic_edit);

            alertDialog.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();

                    realmHelper = new RealmHelper(realm);
                    realmHelper.update(id,
                            edtNim.getText().toString(),
                            edtNama.getText().toString(),
                            edtKelas.getText().toString(),
                            edtTelepon.getText().toString(),
                            edtEmail.getText().toString(),
                            edtInstagram.getText().toString());
                    Toast.makeText(context, "Update Berhasil", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(context, Friends.class);
                    context.startActivity(intent);
                    ((Activity) context).finish();
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
    }
}

