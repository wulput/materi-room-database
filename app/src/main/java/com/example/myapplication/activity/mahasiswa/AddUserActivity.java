package com.example.myapplication.activity.mahasiswa;

import static com.example.myapplication.AppApplication.db;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.room.Mahasiswa;
import com.example.myapplication.util.OnClickAdapterItem;

public class AddUserActivity extends AppCompatActivity {

    private Button insertData;
    private EditText etAlamat;
    private EditText etKejuruan;
    private EditText etNama;
    private EditText etNim;
    private String status;
    private int id;
    Mahasiswa mahasiswa;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        insertData = findViewById(R.id.btInsert);
        etAlamat = findViewById(R.id.etAlamat);
        etKejuruan = findViewById(R.id.etKejuruan);
        etNim = findViewById(R.id.etNim);
        etNama = findViewById(R.id.etNama);

        if (getIntent() != null) {
            id = getIntent().getIntExtra("id", 0);
            mahasiswa = db.userDao().findById(id);
            insertData.setText("Update");
        }

        if (mahasiswa == null) {
            mahasiswa = new Mahasiswa();
        }

        insertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etAlamat.getText().toString().isEmpty()&&!etKejuruan.getText().toString().isEmpty()&&
                        !etNama.getText().toString().isEmpty()&&!etNim.getText().toString().isEmpty()){

                    mahasiswa.setAlamat(etAlamat.getText().toString());
                    mahasiswa.setKejuruan(etKejuruan.getText().toString());
                    mahasiswa.setNama(etNama.getText().toString());
                    mahasiswa.setNim(etNim.getText().toString());

                    if (mahasiswa.getId() > 0) {
                        mahasiswa.setId(mahasiswa.getId());
                        db.userDao().update(mahasiswa);
                    } else {
                        db.userDao().insertAll(mahasiswa);
                    }

                    startActivity(new Intent(AddUserActivity.this,UserActivity.class));
                }else {
                    Toast.makeText(getApplicationContext(), "Mohon masukkan dengan benar", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mahasiswa.getId() > 0) {
            etNama.setText(mahasiswa.getNama());
            etNim.setText(mahasiswa.getNim());
            etKejuruan.setText(mahasiswa.getKejuruan());
            etAlamat.setText(mahasiswa.getAlamat());
            insertData.setText("Update");
        }
    }

}