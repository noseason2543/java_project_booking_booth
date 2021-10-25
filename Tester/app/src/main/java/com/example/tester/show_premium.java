package com.example.tester;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class show_premium extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_premium);
        TextView textView;
        textView = findViewById(R.id.textView5);
        textView.setText(result(new premium()));
    }
    public String result(booth in){
        return in.toStrings();
    }
}