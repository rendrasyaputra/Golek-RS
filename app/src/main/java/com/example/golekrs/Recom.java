package com.example.golekrs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Recom extends AppCompatActivity {

    public Button Rs1,Rs2,Rs3,Rs4,Rs5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recom);

        Rs1 = (Button)findViewById(R.id.RS1);
        Rs1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Recom.this, rs1.class);
                startActivity(intent);
            }
        });

        Rs2 = (Button)findViewById(R.id.RS2);
        Rs2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Recom.this, rs2.class);
                startActivity(intent);
            }
        });

        Rs3 = (Button)findViewById(R.id.RS3);
        Rs3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Recom.this, rs3.class);
                startActivity(intent);
            }
        });

        Rs4 = (Button)findViewById(R.id.RS4);
        Rs4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Recom.this, rs4.class);
                startActivity(intent);
            }
        });


        Rs5 = (Button)findViewById(R.id.RS5);
        Rs5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Recom.this, rs5.class);
                startActivity(intent);
            }
        });
    }
}