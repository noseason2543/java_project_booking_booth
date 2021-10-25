package com.example.tester;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class Event1 extends AppCompatActivity {
    KeepUserLogin a = new KeepUserLogin();
    String b = a.getUser();
    TextInputEditText textInputEditTextYourBooth;
    Button buttonBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event1);

        textInputEditTextYourBooth = findViewById(R.id.yourbooth);
        buttonBook = findViewById(R.id.buttonBook);

        buttonBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String yourbooth;
                yourbooth = String.valueOf(textInputEditTextYourBooth.getText());
                if(!yourbooth.equals("")){
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String[] field = new String[1];
                            field[0] = "yourbooth";
                            String[] data = new String[1];
                            data[0] = yourbooth;
                            HttpsTrustManager.allowAllSSL();
                            PutData putData = new PutData("https://192.168.64.2/LoginAndRegister/book.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if(result.equals("Book Success")){
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                    else{
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }

                        }
                    });
                }
                else{
                    Toast.makeText(getApplicationContext(),"All fields required", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}