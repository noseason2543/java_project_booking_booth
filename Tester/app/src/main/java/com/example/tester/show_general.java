package com.example.tester;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class show_general extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_general);
        TextView textView;
        textView = findViewById(R.id.zoneA);
        textView.setText(result(new general()));
    }

    public String result(booth in){
        return in.toStrings();
    }
}