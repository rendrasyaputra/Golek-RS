package com.example.golekrs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class rs1 extends AppCompatActivity {

    public Button Btnrs1, Btntelprs1, ci, k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rs1);
        Btnrs1 = (Button) findViewById(R.id.maprs1);
        Btnrs1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String Mps ="https://www.google.com/maps/place/RSUP+Dr.+Sardjito/@-7.7686215,110.3712887,17z/data=!4m12!1m6!3m5!1s0x2e7a584c3f999547:0xf5f81e9fab2e1dfb!2sRSUP+Dr.+Sardjito!8m2!3d-7.7686163!4d110.3734742!3m4!1s0x2e7a584c3f999547:0xf5f81e9fab2e1dfb!8m2!3d-7.7686163!4d110.3734742";
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Mps)));
            }
        });

        Btntelprs1 = (Button)findViewById(R.id.telprs1);
        Btntelprs1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Tlp ="tel:"+"0274631190";
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(Tlp)));
            }
        });
        ci = (Button)findViewById(R.id.cekrs);
        ci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(rs1.this, checkin.class);
                startActivity(intent);
            }
        });
    }
}