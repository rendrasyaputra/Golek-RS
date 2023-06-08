package com.example.golekrs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class daftar extends AppCompatActivity {
    TextInputEditText id,pw,cp;
    Button daftar;
    DataHelper db;
    TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        db = new DataHelper(this);
        id = (TextInputEditText) findViewById(R.id.username);
        pw = (TextInputEditText) findViewById(R.id.password);
        cp = (TextInputEditText) findViewById(R.id.confirmpassword);
        login = (TextView)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(daftar.this, Login.class);
                startActivity(intent);
            }
        });
        daftar = (Button)findViewById(R.id.daftar);
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUsername = id.getText().toString();
                String strPassword = pw.getText().toString();
                String strPasswordConf = cp.getText().toString();
                if (strPassword.equals(strPasswordConf)) {
                    Boolean daftar = db.insertUser(strUsername, strPassword);
                    if (daftar == true) {
                        Toast.makeText(getApplicationContext(), "Daftar Berhasil", Toast.LENGTH_SHORT).show();
                        Intent loginIntent = new Intent(daftar.this, Login.class);
                        startActivity(loginIntent);
                        finish();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Daftar Gagal", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Password Tidak Cocok", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}