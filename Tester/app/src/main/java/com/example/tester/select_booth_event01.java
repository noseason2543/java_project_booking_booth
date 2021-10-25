package com.example.tester;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class select_booth_event01 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_event01);
        TextView zoneA = findViewById(R.id.zoneA);
        TextView zoneB = findViewById(R.id.zoneB);
        TextView zoneC = findViewById(R.id.zoneC);
        TextView zoneD = findViewById(R.id.zoneD);
        TextView zoneE = findViewById(R.id.zoneE);
        zoneA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select_booth c = new select_booth();
                c.setZone(1);
                Intent intent = new Intent(getApplicationContext(),selectBoothtype.class);
                startActivity(intent);
            }
        });
        zoneB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select_booth c = new select_booth();
                c.setZone(2);
                Intent intent = new Intent(getApplicationContext(),selectBoothtype.class);
                startActivity(intent);
            }
        });
        zoneC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select_booth c = new select_booth();
                c.setZone(3);
                Intent intent = new Intent(getApplicationContext(),selectBoothtype.class);
                startActivity(intent);
            }
        });
        zoneD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select_booth c = new select_booth();
                c.setZone(4);
                Intent intent = new Intent(getApplicationContext(),selectBoothtype.class);
                startActivity(intent);
            }
        });
        zoneE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select_booth c = new select_booth();
                c.setZone(5);
                Intent intent = new Intent(getApplicationContext(),selectBoothtype.class);
                startActivity(intent);
            }
        });
    }
}