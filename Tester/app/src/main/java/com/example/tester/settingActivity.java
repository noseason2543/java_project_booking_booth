package com.example.tester;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.vishnusivadas.advanced_httpurlconnection.FetchData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class settingActivity extends AppCompatActivity {
    private static final String URL_PRODUCTS = "http://192.168.101.1/LoginAndRegister/realread.php";
    List<Product> productList;
    Button buttonRead;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        TextView readText =findViewById(R.id.readText);
        productList = new ArrayList<>();

        buttonRead = findViewById(R.id.buttonRead);
        buttonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadProducts();
            }
        });
//        Intent i = getIntent();
//        String message = getIntent().getStringExtra("text1");
//        ((Button) findViewById(R.id.button3)).setText(message);
//        buttonRead.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Start ProgressBar first (Set visibility VISIBLE)
//                Handler handler = new Handler(Looper.getMainLooper());
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        FetchData fetchData = new FetchData("https://192.168.64.2/LoginAndRegister/read.php");
//                        if (fetchData.startFetch()) {
//                            if (fetchData.onComplete()) {
//                                String result = fetchData.getResult();
//                                //End ProgressBar (Set visibility to GONE)
//                                Log.i("FetchData", result);
//                            }
//                        }
//                    }
//                });
//            }
//        });
    }
    private void loadProducts(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_PRODUCTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //converting the string to json array object
                            JSONArray array = new JSONArray(response);

                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {

                                //getting product object from json array
                                JSONObject product = array.getJSONObject(i);

                                //adding the product to product list
                                productList.add(new Product(
                                        product.getInt("id"),
                                        product.getString("username"),
                                        product.getString("email")
                                ));
                            }



                        }
                        catch(JSONException e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }
}