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

public class EditActivity extends AppCompatActivity {
    Button buttonEdit;
    TextInputEditText textInputEditTextEdit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);


        KeepUserLogin a = new KeepUserLogin();
        String username;
        username = a.getUser();

        textInputEditTextEdit = findViewById(R.id.editemail);
        buttonEdit = findViewById(R.id.buttonEdit);

        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email;
                email = String.valueOf(textInputEditTextEdit.getText());
                if(!email.equals("")) {
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                            String[] field = new String[2];
                            field[0] = "username";
                            field[1] = "email";
                            String[] data = new String[2];
                            data[0] = username;
                            data[1] = email;
                            HttpsTrustManager.allowAllSSL();
                            PutData putData = new PutData("https://192.168.64.2/LoginAndRegister/editemail.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if(result.equals("Edit Success")){
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
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