package com.example.golekrs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {
    TextInputEditText id,pw;
    Button login;
    DataHelper db;
    TextView daftar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        daftar = (TextView)findViewById(R.id.daftar);
        db = new DataHelper(this);
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, daftar.class);
                startActivity(intent);
            }
        });
        id = (TextInputEditText) findViewById(R.id.username);
        pw = (TextInputEditText) findViewById(R.id.password);
        login = (Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUsername = id.getText().toString();
                String strPassword = pw.getText().toString();
                Boolean masuk = db.checkLogin(strUsername, strPassword);
                if (masuk == true) {
                    Boolean updateSession = db.upgradeSession("ada", 1);
                    if (updateSession == true) {
                        Toast.makeText(getApplicationContext(), "Selamat Datang di Golek RS", Toast.LENGTH_SHORT).show();
                        Intent mainIntent = new Intent(Login.this, Help.class);
                        startActivity(mainIntent);
                        finish();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Masuk Gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}