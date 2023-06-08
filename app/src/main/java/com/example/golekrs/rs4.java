package com.example.golekrs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class rs4 extends AppCompatActivity {

    public Button Btnrs4, Btntelprs4, ci;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rs4);

        Btnrs4 = (Button)findViewById(R.id.maprs4);
        Btnrs4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Mps = "https://www.google.com/maps/place/RSI+Hidayatullah/@-7.8153242,110.3855665,17z/data=!3m1!4b1!4m5!3m4!1s0x2e7a5772d6ee627d:0xb391687cf415780f!8m2!3d-7.8153295!4d110.3877552";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Mps)));
            }
        });

        Btntelprs4 = (Button)findViewById(R.id.telprs4);
        Btntelprs4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Tlp ="tel:"+"0274389194";
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(Tlp)));
            }
        });
        ci = (Button)findViewById(R.id.cekrs);
        ci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(rs4.this, checkin.class);
                startActivity(intent);
            }
        });
    }
}