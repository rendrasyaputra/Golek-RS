package com.example.golekrs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class rs3 extends AppCompatActivity {
    public Button Btnrs3, Btntelprs3, ci;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rs3);

        Btnrs3 = (Button) findViewById(R.id.maprs3);
        Btnrs3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Mps ="https://www.google.com/maps/place/RS+PKU+Muhammadiyah+Yogyakarta/@-7.8007405,110.3601221,17z/data=!3m1!4b1!4m5!3m4!1s0x2e7a5789348d80a1:0x7b6a2154d80337be!8m2!3d-7.8007405!4d110.3623108";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Mps)));
            }
        });

        Btntelprs3 = (Button)findViewById(R.id.telprs3);
        Btntelprs3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Tlp ="tel:"+"0274512653";
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(Tlp)));
            }
        });
        ci = (Button)findViewById(R.id.cekrs);
        ci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(rs3.this, checkin.class);
                startActivity(intent);
            }
        });

    }
}