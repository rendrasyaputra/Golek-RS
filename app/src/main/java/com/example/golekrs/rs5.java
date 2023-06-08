package com.example.golekrs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class rs5 extends AppCompatActivity {
    Button ci;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rs5);
        ci = (Button)findViewById(R.id.cekrs);
        ci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(rs5.this, checkin.class);
                startActivity(intent);
            }
        });
    }
}