package com.example.golekrs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class rs2 extends AppCompatActivity {
    public Button Btnrs2, Btntelprs2, ci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rs2);

        Btnrs2 = (Button) findViewById(R.id.maprs2);
        Btnrs2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Mps ="https://www.google.com/maps/place/RSUD+Kota+Yogyakarta/@-7.8258225,110.3758179,17z/data=!3m1!4b1!4m5!3m4!1s0x2e7a57a7b80d5957:0x119b0fcaefe41db6!8m2!3d-7.8258278!4d110.3780066";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Mps)));
            }
        });

        Btntelprs2 = (Button)findViewById(R.id.telprs2);
        Btntelprs2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Tlp ="tel:"+"0274371195";
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(Tlp)));
            }
        });
        ci = (Button)findViewById(R.id.cekrs);
        ci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(rs2.this, checkin.class);
                startActivity(intent);
            }
        });

    }
}