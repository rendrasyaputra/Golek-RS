package com.example.golekrs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Help extends AppCompatActivity {

    ImageView Maps, Recom;
    Button BtnMaps, BtnRecom, Mapslangsung;
    DataHelper db;
    EditText KetikMaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        KetikMaps =(EditText)findViewById(R.id.ketikmaps);
        Mapslangsung =(Button)findViewById(R.id.mapslangsung);

        Mapslangsung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Mp = KetikMaps.getText().toString();
                if (!TextUtils.isEmpty(Mp)){
                    String Mps = "https://www.google.com/maps/search/"+Mp;
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Mps)));
                }
                else {
                    Toast.makeText(Help.this, "Masukkan Nama RS", Toast.LENGTH_SHORT).show();
                }
            }
        });


        Maps = (ImageView)findViewById(R.id.maps);
        BtnMaps = (Button)findViewById(R.id.btnmaps);
        Maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Help.this, MapsActivity.class);
                startActivity(intent);
            }
        });
        BtnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Help.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        Recom = (ImageView)findViewById(R.id.recom);
        BtnRecom = (Button)findViewById(R.id.btnrecom);
        Recom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Help.this, Recom.class);
                startActivity(intent);
            }
        });
        BtnRecom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Help.this, Recom.class);
                startActivity(intent);
            }
        });

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the main; this adds items to the action bar ifit is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.lo){
                Toast.makeText(getApplicationContext(), "Berhasil Keluar", Toast.LENGTH_SHORT).show();
                Intent loginIntent = new Intent(Help.this, Login.class);
                startActivity(loginIntent);
                finish();
            }
        return super.onOptionsItemSelected(item);

    }
}