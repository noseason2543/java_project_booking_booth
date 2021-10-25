package com.example.tester;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class selectBoothtype extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_boothtype);
        TextView general,premium;
        Button buttonGeneral,buttonPremium;
        general = findViewById(R.id.textView2);
        premium = findViewById(R.id.zoneE);
        buttonGeneral = findViewById(R.id.button);
        buttonPremium =findViewById(R.id.button3);
        buttonGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select_booth c = new select_booth();
                c.setBooth_type("general");
                Intent intent = new Intent(getApplicationContext(),image_testFetch.class);
                startActivity(intent);
            }
        });
        buttonPremium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select_booth c = new select_booth();
                c.setBooth_type("premium");
                Intent intent = new Intent(getApplicationContext(),image_testFetch.class);
                startActivity(intent);
            }
        });
        general.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),show_general.class);
                startActivity(intent);
            }
        });
        premium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),show_premium.class);
                startActivity(intent);
            }
        });
    }
}