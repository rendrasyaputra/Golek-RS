package com.example.golekrs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class checkin extends AppCompatActivity {
    Button submit;
    EditText nama,nope,alamat;
    DataHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkin);
        dbHelper = new DataHelper(this);
        nama = (EditText) findViewById(R.id.nama);
        nope = (EditText) findViewById(R.id.nope);
        alamat = (EditText) findViewById(R.id.alamat);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into pasien(no, nama, alamat)  values('" +
                        nama.getText().toString()+"','"+
                        nope.getText().toString() +"','" +
                        alamat.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                Intent pesanIntent = new Intent(checkin.this, Help.class);
                startActivity(pesanIntent);
                finish();
            }
        });

    }
}